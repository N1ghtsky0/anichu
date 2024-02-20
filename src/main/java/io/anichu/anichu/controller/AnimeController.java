package io.anichu.anichu.controller;

import io.anichu.anichu.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AnimeController {
    private final AnimeService animeService;

    @GetMapping("/anime/{name}")
    public String animeDetailPage(@PathVariable("name") String name, Model model) {
        log.info(URLDecoder.decode(name, StandardCharsets.UTF_8));
        model.addAttribute("animeVO", animeService.getAnimeDetailByTitle(name.strip()));
        return "/anime/detail";
    }
}
