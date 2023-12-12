package io.anichu.anichu.service.impl;

import io.anichu.anichu.dto.response.AnimeAvgScoreDTO;
import io.anichu.anichu.entity.Anime;
import io.anichu.anichu.repository.mapper.CommentMapper;
import io.anichu.anichu.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    @Override
    @Transactional(readOnly = true)
    public AnimeAvgScoreDTO getAnimeAverageScore(Anime anime) {
        return commentMapper.selectAnimeAvgScore(anime.getSeq());
    }
}
