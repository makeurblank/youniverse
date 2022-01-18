package dto;

import domain.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User loginUser) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }
}
