package io.anichu.anichu.controller;

import io.anichu.anichu.service.AnimeService;
import io.anichu.anichu.service.CommentService;
import io.anichu.anichu.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@RequiredArgsConstructor
@RequestMapping("/anime")
@Controller
public class AnimeController {
    private final AnimeService animeService;
    private final CommentService commentService;
    private final TagService tagService;

    @GetMapping()
    public String animeListPage(@RequestParam HashMap<String, Object> hashMap,
                                Model model) {
        model.addAttribute("animeCardList", animeService.searchAnime(hashMap));

        return "anime/list";
    }

    @GetMapping("/{seq}")
    public String animeMainPage(@PathVariable("seq") Long seq,
                                Model model) {
        model.addAttribute("anime", animeService.getAnime(seq));
        model.addAttribute("score", commentService.getAnimeAverageScore(seq));
        model.addAttribute("commentList", commentService.getComments(seq));

        return "anime/detail";
    }

    @GetMapping("/tag")
    public String tagSearch(@RequestParam("name") String tags,
                            Model model) {
        model.addAttribute("animeCardList", tagService.getAllAnimeByTag(tags.split(",")));

        return "anime/list";
    }
}
