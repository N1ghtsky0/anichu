package io.anichu.anichu.vo;

import io.anichu.anichu.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Setter
@Getter
public class UserVO {
    private String email;
    private String password;
    private String passwordCheck;
    private String nickName;

    public Boolean isEqualPasswords() {
        return password.equals(passwordCheck);
    }

    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .nickName((nickName.isEmpty()) ? email.split("@")[0] : nickName)
                .build();
    }
}
