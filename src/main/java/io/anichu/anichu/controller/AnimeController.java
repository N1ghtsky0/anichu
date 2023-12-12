package io.anichu.anichu.controller;

import io.anichu.anichu.service.AnimeService;
import io.anichu.anichu.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/anime")
@Controller
public class AnimeController {
    private final AnimeService animeService;
    private final CommentService commentService;

    @GetMapping("/{seq}")
    public String animeMainPage(@PathVariable("seq") Long seq,
                                Model model) {
        model.addAttribute("anime", animeService.getAnime(seq));
        model.addAttribute("score", commentService.getAnimeAverageScore(seq));

        return "anime/anime";
    }
}
