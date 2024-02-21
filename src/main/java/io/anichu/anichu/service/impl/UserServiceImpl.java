package io.anichu.anichu.service.impl;

import io.anichu.anichu.repository.UserRepo;
import io.anichu.anichu.service.UserService;
import io.anichu.anichu.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void join(UserVO userVO) {
        userRepo.save(userVO.toEntity(passwordEncoder));
    }

    @Override
    public Boolean isEmailDuplicated(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("email: {%s} 유저를 찾을 수 없습니다.", username)));
    }
}
