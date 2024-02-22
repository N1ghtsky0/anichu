package io.anichu.anichu.controller;

import io.anichu.anichu.service.AnimeService;
import io.anichu.anichu.util.CommonController;
import io.anichu.anichu.vo.AnimeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/adm")
@Controller
public class AdminAnimeController extends CommonController {
    private final AnimeService animeService;

    @GetMapping("/anime/insert")
    public String animeInsertPage() {
        return "/admin/anime/insertForm";
    }

    @PostMapping("/anime/insert")
    public String animeInsertProcess(AnimeVO animeVO, @RequestParam("thumbnail") MultipartFile file) {
        animeService.insertAnime(animeVO, file);
        return "redirect:/adm/anime/insert";
    }
}
