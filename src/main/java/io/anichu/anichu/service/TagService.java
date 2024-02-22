package io.anichu.anichu.service;

import io.anichu.anichu.vo.AnimeVO;

import java.util.List;

public interface TagService {
    List<String> getAllTagsByAnime(AnimeVO vo);
}
