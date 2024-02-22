package io.anichu.anichu.controller;

import io.anichu.anichu.util.CommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/adm")
@Controller
public class AdminAnimeController extends CommonController {
    @GetMapping("/anime/insert")
    public String animeInsertPage() {
        return "/admin/anime/insertForm";
    }
}
