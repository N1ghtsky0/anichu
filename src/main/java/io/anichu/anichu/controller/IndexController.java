package io.anichu.anichu.controller;

import io.anichu.anichu.service.AnimeService;
import io.anichu.anichu.service.ProductionCompanyService;
import io.anichu.anichu.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final ProductionCompanyService productionCompanyService;
    private final AnimeService animeService;
    private final TagService tagService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("companyList", productionCompanyService.getAllProductionCompany());
        model.addAttribute("animeCardList", animeService.getRecommendAnimeSummaryCards());
        model.addAttribute("tagList", tagService.getAllTags());

        return "/index";
    }
}
