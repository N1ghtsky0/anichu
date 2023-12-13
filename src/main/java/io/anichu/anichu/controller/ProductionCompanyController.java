package io.anichu.anichu.controller;

import io.anichu.anichu.service.AnimeService;
import io.anichu.anichu.service.ProductionCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/company")
@Controller
public class ProductionCompanyController {
    private final ProductionCompanyService productionCompanyService;
    private final AnimeService animeService;

    @GetMapping("/{seq}")
    private String companyMainPage(@PathVariable("seq") Long seq,
                                   Model model) {
        model.addAttribute("company", productionCompanyService.getProductionCompany(seq));
        model.addAttribute("animeCards", animeService.getAllAnimeSummaryCardByCompany(seq));

        return "company/detail";
    }
}
