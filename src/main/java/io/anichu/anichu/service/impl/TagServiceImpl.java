package io.anichu.anichu.service.impl;

import io.anichu.anichu.repository.mapper.TagMapper;
import io.anichu.anichu.service.TagService;
import io.anichu.anichu.vo.AnimeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagMapper tagMapper;

    @Override
    public List<String> getAllTagsByAnime(AnimeVO vo) {
        return tagMapper.selectAllTagsByAnime(vo);
    }
}
