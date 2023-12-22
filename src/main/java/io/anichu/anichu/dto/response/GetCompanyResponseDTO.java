package io.anichu.anichu.dto.response;

import io.anichu.anichu.entity.ProductionCompany;
import lombok.Builder;

@Builder
public class GetCompanyResponseDTO {
    private String companyName;

    public static GetCompanyResponseDTO from(ProductionCompany entity) {
        return GetCompanyResponseDTO.builder()
                .companyName(entity.getName())
                .build();
    }
}
