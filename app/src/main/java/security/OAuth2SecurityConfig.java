package security;

import application.SocialLoginService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class OAuth2SecurityConfig extends WebSecurityConfigurerAdapter {

    private final SocialLoginService socialLoginService;


    public OAuth2SecurityConfig(SocialLoginService socialLoginService) {
        this.socialLoginService = socialLoginService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
