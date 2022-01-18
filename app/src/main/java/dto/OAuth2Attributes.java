package dto;

import domain.Role;
import domain.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuth2Attributes {
    private Map<String, Object> attributes;
    private String nameKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuth2Attributes(Map<String, Object> attributes,
                            String nameKey,
                            String name, String email, String picture) {
        this.attributes = attributes;
        this.nameKey = nameKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuth2Attributes of(
            String id, String userName, Map<String, Object> attributes
    ) {
        return ofGoogle(userName, attributes);
    }

    private static OAuth2Attributes ofGoogle(
            String userName, Map<String, Object> attributes) {

        return OAuth2Attributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameKey(userName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.USER)
                .build();
    }

}
