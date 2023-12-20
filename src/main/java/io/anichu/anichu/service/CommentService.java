package io.anichu.anichu.service;

import io.anichu.anichu.dto.response.AnimeAvgScoreDTO;
import io.anichu.anichu.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    AnimeAvgScoreDTO getAnimeAverageScore(Long animeSeq);

    Page<Comment> getComments(Long seq, Pageable pageable);
}
