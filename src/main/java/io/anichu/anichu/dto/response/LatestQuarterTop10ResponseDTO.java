package io.anichu.anichu.dto.response;

import lombok.Builder;

import java.util.HashMap;
import java.util.List;

@Builder
public class LatestQuarterTop10ResponseDTO {
    private String quarter;
    private List<AnimeCardResponseDTO> responseDTOList;

    public static LatestQuarterTop10ResponseDTO from(String quarter, List<HashMap<String, Object>> hashMapList) {
        return LatestQuarterTop10ResponseDTO.builder()
                .quarter(quarter)
                .responseDTOList(hashMapList.stream()
                        .map(AnimeCardResponseDTO::from)
                        .toList())
                .build();
    }
}
