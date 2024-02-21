package io.anichu.anichu.controller;

import io.anichu.anichu.service.UserService;
import io.anichu.anichu.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/join")
    public String joinPage() {
        return "/auth/join";
    }

    @PostMapping("/join")
    public String joinProcess(UserVO userVO, Model model) {
        String returnPage = "/auth/join";

        if (!userVO.isEqualPasswords()) {   //비밀번호와 비밀번호 확인이 일치하지 않는 경우
            model.addAttribute("userVO", userVO);
            model.addAttribute("errorMsg", "비밀번호가 일치하지 않습니다!");
        } else if (userService.isEmailDuplicated(userVO.getEmail())) {  //이미 가입된 이메일인 경우
            model.addAttribute("userVO", userVO);
            model.addAttribute("errorMsg", "해당 이메일로 가입된 계정이 있습니다.");
            returnPage = "/auth/findAccount";
        } else {
            userService.join(userVO);
        }

        return returnPage;
    }
}
