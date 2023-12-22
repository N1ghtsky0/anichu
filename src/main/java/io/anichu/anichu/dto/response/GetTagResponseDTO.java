package io.anichu.anichu.dto.response;

import io.anichu.anichu.entity.Tag;
import lombok.Builder;

@Builder
public class GetTagResponseDTO {
    private String tagName;

    public static GetTagResponseDTO from(Tag entity) {
        return GetTagResponseDTO.builder()
                .tagName(entity.getName())
                .build();
    }
}
