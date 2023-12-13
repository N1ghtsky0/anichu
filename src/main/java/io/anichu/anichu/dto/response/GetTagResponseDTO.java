package io.anichu.anichu.dto.response;

import io.anichu.anichu.entity.Tag;
import lombok.Builder;

@Builder
public class GetTagResponseDTO {
    private Long seq;
    private String tagName;

    public static GetTagResponseDTO from(Tag entity) {
        return GetTagResponseDTO.builder()
                .seq(entity.getSeq())
                .tagName(entity.getName())
                .build();
    }
}
