package io.anichu.anichu.service;

import io.anichu.anichu.dto.response.AnimeAvgScoreDTO;
import io.anichu.anichu.entity.Anime;

public interface CommentService {
    AnimeAvgScoreDTO getAnimeAverageScore(Anime anime);
}
