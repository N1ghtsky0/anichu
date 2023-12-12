package io.anichu.anichu.dto.response;

import io.anichu.anichu.entity.Comment;
import lombok.Builder;

@Builder
public class GetCommentsResponseDTO {
    private String content;
    private Integer score;

    public static GetCommentsResponseDTO from(Comment entity) {
        return GetCommentsResponseDTO.builder()
                .content(entity.getContent())
                .score(entity.getScore())
                .build();
    }
}
