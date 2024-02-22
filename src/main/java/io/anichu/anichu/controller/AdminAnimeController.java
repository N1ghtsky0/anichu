package io.anichu.anichu.controller;

import io.anichu.anichu.service.AnimeService;
import io.anichu.anichu.service.FileService;
import io.anichu.anichu.service.TagService;
import io.anichu.anichu.util.CommonController;
import io.anichu.anichu.vo.AnimeVO;
import io.anichu.anichu.vo.FileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/adm")
@Controller
public class AdminAnimeController extends CommonController {
    private final AnimeService animeService;
    private final TagService tagService;
    private final FileService fileService;

    @GetMapping("/anime/insert")
    public String animeInsertPage(Model model) {
        AnimeVO animeVO = new AnimeVO();
        animeVO.setSeq(0L);

        model.addAttribute("tagList", tagService.getAllTagsByAnime(animeVO));
        return "/admin/anime/insertForm";
    }

    @PostMapping("/anime/insert")
    public String animeInsertProcess(AnimeVO animeVO, @RequestParam("thumbnail") MultipartFile file) {
        animeService.insertAnime(animeVO, file);
        return "redirect:/adm/anime/insert";
    }

    @GetMapping("/anime/update/{seq}")
    public String animeUpdatePage(@PathVariable("seq") Long seq, Model model) {
        AnimeVO animeVO = animeService.getAnimeDetailBySeq(seq);
        FileVO fileVO = fileService.getFileByAnime(animeVO);
        List<String> tagList = tagService.getAllTagsByAnime(animeVO);

        model.addAttribute("animeVO", animeVO);
        model.addAttribute("fileVO", fileVO);
        model.addAttribute("tagList", tagList);
        return "/admin/anime/insertForm";
    }
}
