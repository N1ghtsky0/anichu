package io.anichu.anichu.util;

import io.anichu.anichu.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CommonController {
    @ModelAttribute
    public void loginCheck(Authentication authentication, Model model) {
        if (authentication != null) {
            User user = (User) authentication.getPrincipal();
            model.addAttribute("nickName", user.getNickName());

            if (User.Role.ADMIN.equals(user.getRole())) {
                model.addAttribute("userAdmin", true);
            }
        }
    }
}
