package io.anichu.anichu.repository.mapper;

import io.anichu.anichu.dto.response.GetAnimeSummaryResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnimeMapper {
    List<GetAnimeSummaryResponseDTO> selectTop10Anime();
}
