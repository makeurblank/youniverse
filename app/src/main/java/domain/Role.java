package domain;

import lombok.Getter;

@Getter
public enum Role {
    USER("사용자", true);

    private final String key;
    private final boolean value;

    Role(String key, boolean value) {
        this.key = key;
        this.value = value;
    }
}
