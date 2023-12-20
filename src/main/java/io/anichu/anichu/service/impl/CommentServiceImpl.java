package io.anichu.anichu.service.impl;

import io.anichu.anichu.dto.response.AnimeAvgScoreDTO;
import io.anichu.anichu.entity.Comment;
import io.anichu.anichu.repository.AnimeRepo;
import io.anichu.anichu.repository.CommentRepo;
import io.anichu.anichu.repository.mapper.CommentMapper;
import io.anichu.anichu.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;
    private final CommentMapper commentMapper;
    private final AnimeRepo animeRepo;

    @Override
    @Transactional(readOnly = true)
    public AnimeAvgScoreDTO getAnimeAverageScore(Long seq) {
        return commentMapper.selectAnimeAvgScore(seq);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Comment> getComments(Long seq, Pageable pageable) {
        return commentRepo.findAllByAnimeAndDeletedFalse(animeRepo.findById(seq).orElseThrow(), pageable);
    }
}
