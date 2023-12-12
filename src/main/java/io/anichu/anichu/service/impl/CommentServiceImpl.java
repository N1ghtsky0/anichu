package io.anichu.anichu.service.impl;

import io.anichu.anichu.dto.response.AnimeAvgScoreDTO;
import io.anichu.anichu.repository.mapper.CommentMapper;
import io.anichu.anichu.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    @Override
    public AnimeAvgScoreDTO getAnimeAverageScore(Long seq) {
        return commentMapper.selectAnimeAvgScore(seq);
    }
}
