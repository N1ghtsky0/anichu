package io.anichu.anichu.service;

import io.anichu.anichu.vo.AnimeVO;
import org.springframework.web.multipart.MultipartFile;

public interface AnimeService {
    AnimeVO getAnimeDetailByTitle(String title);

    AnimeVO getAnimeDetailBySeq(Long seq);

    void insertAnime(AnimeVO vo, MultipartFile file);
}
