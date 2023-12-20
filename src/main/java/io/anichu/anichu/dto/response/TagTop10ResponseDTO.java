package io.anichu.anichu.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

@Builder
@Getter
public class TagTop10ResponseDTO {
    private String tag;
    private List<AnimeCardResponseDTO> responseDTOList;

    public static TagTop10ResponseDTO from(String tag, List<HashMap<String, Object>> hashMapList) {
        return TagTop10ResponseDTO.builder()
                .tag(tag)
                .responseDTOList(hashMapList.stream()
                        .map(AnimeCardResponseDTO::from)
                        .toList())
                .build();
    }
}
