package io.anichu.anichu.controller;

import io.anichu.anichu.dto.request.InsertCompanyRequestDTO;
import io.anichu.anichu.service.ProductionCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/company/new")
    public String companyInsertPage() {
        return "/admin/company/insert";
    }

    @PostMapping("/company/new")
    public String companyInsertProcess(InsertCompanyRequestDTO requestDTO) {
        productionCompanyService.insertProductCompany(requestDTO);

        return "redirect:/admin/company";
    }

}
