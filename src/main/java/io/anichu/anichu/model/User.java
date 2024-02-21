package io.anichu.anichu.model;

import io.anichu.anichu.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Comment("유저")
@Entity
public class User extends BaseTimeEntity implements UserDetails {
    public enum Role {
        USER, ADMIN
    }

    @Comment("유저 시퀀스")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Comment("유저 고유번호")
    @Column(nullable = false)
    @Builder.Default
    private String uuid = UUID.randomUUID().toString();

    @Comment("로그인 아이디(이메일)")
    @Column(nullable = false, updatable = false)
    private String email;

    @Comment("로그인 비밀번호")
    @Column(nullable = false)
    private String password;

    @Comment("유저 닉네임")
    private String nickName;

    @Comment("권한")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.USER;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(() -> role.name());
        return collection;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
