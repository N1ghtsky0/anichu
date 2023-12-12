package io.anichu.anichu.service;

import io.anichu.anichu.dto.response.AnimeAvgScoreDTO;
import io.anichu.anichu.dto.response.GetCommentsResponseDTO;

import java.util.List;

public interface CommentService {
    AnimeAvgScoreDTO getAnimeAverageScore(Long animeSeq);

    List<GetCommentsResponseDTO> getComments(Long seq);
}
