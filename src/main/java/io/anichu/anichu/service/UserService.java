package io.anichu.anichu.service;

import io.anichu.anichu.vo.UserVO;

public interface UserService {
    void join(UserVO userVO);

    Boolean isEmailDuplicated(String email);
}
