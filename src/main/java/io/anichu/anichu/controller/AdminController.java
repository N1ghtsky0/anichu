package io.anichu.anichu.controller;

import io.anichu.anichu.service.ProductionCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/admin")
@Controller
public class AdminController {
    public final ProductionCompanyService productionCompanyService;

    @GetMapping("/company")
    public String companyManagePage(Model model) {
        model.addAttribute("list", productionCompanyService.getAllProductionCompany());
        return "/admin/company/list";
    }

}
