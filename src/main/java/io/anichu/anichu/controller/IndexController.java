package io.anichu.anichu.controller;

import io.anichu.anichu.util.CommonController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController extends CommonController {
    @GetMapping({"/", "/index"})
    public String indexPage() {
        return "/index";
    }
}
