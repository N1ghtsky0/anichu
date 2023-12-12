package io.anichu.anichu.repository.mapper;

import io.anichu.anichu.dto.response.AnimeAvgScoreDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    AnimeAvgScoreDTO selectAnimeAvgScore(long animeId);
}
