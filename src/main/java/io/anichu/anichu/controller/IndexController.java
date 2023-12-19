package io.anichu.anichu.controller;

import io.anichu.anichu.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final AnimeService animeService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("Top10All", animeService.getTotalTop10());
        model.addAttribute("Top10Quarter", animeService.getLatestQuarterTop10());

        return "/index";
    }
}
