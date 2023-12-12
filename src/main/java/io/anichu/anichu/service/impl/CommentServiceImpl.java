package io.anichu.anichu.service.impl;

import io.anichu.anichu.dto.response.AnimeAvgScoreDTO;
import io.anichu.anichu.dto.response.GetCommentsResponseDTO;
import io.anichu.anichu.repository.AnimeRepo;
import io.anichu.anichu.repository.CommentRepo;
import io.anichu.anichu.repository.mapper.CommentMapper;
import io.anichu.anichu.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<GetCommentsResponseDTO> getComments(Long seq) {
        return commentRepo.findAllByAnimeAndDeletedFalse(animeRepo.findById(seq).orElseThrow()).stream()
                .map(GetCommentsResponseDTO::from)
                .toList();
    }
}
