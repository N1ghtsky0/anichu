package io.anichu.anichu.controller;

import io.anichu.anichu.service.ProductionCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final ProductionCompanyService productionCompanyService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("companyList", productionCompanyService.getAllProductionCompany());

        return "/index";
    }
}
