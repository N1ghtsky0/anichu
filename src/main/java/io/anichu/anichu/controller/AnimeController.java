package io.anichu.anichu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AnimeController {
    @GetMapping("/anime/{seq}")
    public String animeDetailPage(@PathVariable("seq") Long seq) {
        return "/anime/detail";
    }
}
