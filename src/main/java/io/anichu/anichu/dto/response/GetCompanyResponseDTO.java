package io.anichu.anichu.dto.response;

import io.anichu.anichu.entity.ProductionCompany;
import lombok.Builder;

@Builder
public class GetCompanyResponseDTO {
    private Long seq;
    private String name;

    public static GetCompanyResponseDTO from(ProductionCompany entity) {
        return GetCompanyResponseDTO.builder()
                .seq(entity.getSeq())
                .name(entity.getName())
                .build();
    }
}
