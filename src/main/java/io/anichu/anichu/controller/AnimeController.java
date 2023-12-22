package io.anichu.anichu.controller;

import io.anichu.anichu.dto.request.AnimeSearchRequestDTO;
import io.anichu.anichu.service.AnimeService;
import io.anichu.anichu.service.CommentService;
import io.anichu.anichu.service.ProductionCompanyService;
import io.anichu.anichu.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/anime")
@Controller
public class AnimeController {
    private final AnimeService animeService;
    private final CommentService commentService;
    private final TagService tagService;
    private final ProductionCompanyService productionCompanyService;

    @GetMapping()
    public String animeListPage(Model model) {
        model.addAttribute("tags", tagService.getAllTags());
        model.addAttribute("companies", productionCompanyService.getAllProductionCompany());
        return "anime/list";
    }

    @GetMapping("/{seq}")
    public String animeMainPage(@PathVariable("seq") Long seq,
                                Model model) {
        model.addAttribute("anime", animeService.getAnime(seq));
        model.addAttribute("score", commentService.getAnimeAverageScore(seq));

        return "anime/detail";
    }

    @GetMapping("/tag")
    public String tagSearch(@RequestParam("name") String tags,
                            Model model) {
        model.addAttribute("animeCardList", tagService.getAllAnimeByTag(tags.split(",")));

        return "anime/list";
    }

    @PostMapping("/search")
    @ResponseBody
    public ResponseEntity<?> searchAnime(AnimeSearchRequestDTO requestDTO) {
        return ResponseEntity.ok(requestDTO);
    }
}
