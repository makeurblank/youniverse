package application;

import domain.User;
import dto.OAuth2Attributes;
import dto.SessionUser;
import infra.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@Service
public class SocialLoginService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    public SocialLoginService(UserRepository userRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User user = delegate.loadUser(userRequest);

        String id = userRequest.getClientRegistration().getRegistrationId();

        String userName = userRequest
                .getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();


        OAuth2Attributes attributes = OAuth2Attributes.of(
                id, userName, user.getAttributes()
        );

        User loginUser = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUser(loginUser));

        return new DefaultOAuth2User(Collections.singleton(
                new SimpleGrantedAuthority(loginUser.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameKey());

    }

    private User saveOrUpdate(OAuth2Attributes attributes) {
        User user = userRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return userRepository.save(user);
    }
}

