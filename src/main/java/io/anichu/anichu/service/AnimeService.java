package io.anichu.anichu.service;

import io.anichu.anichu.vo.AnimeVO;

public interface AnimeService {
    AnimeVO getAnimeDetailByTitle(String title);
}
