package io.anichu.anichu.service;

import io.anichu.anichu.dto.response.AnimeAvgScoreDTO;

public interface CommentService {
    AnimeAvgScoreDTO getAnimeAverageScore(Long animeSeq);
}
