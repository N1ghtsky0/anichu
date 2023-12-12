package io.anichu.anichu.service;

import io.anichu.anichu.dto.request.InsertCompanyRequestDTO;
import io.anichu.anichu.dto.response.GetCompanyResponseDTO;

import java.util.List;

public interface ProductionCompanyService {
    void insertProductCompany(InsertCompanyRequestDTO requestDTO);

    GetCompanyResponseDTO getProductionCompany(Long seq);

    List<GetCompanyResponseDTO> getAllProductionCompany();
}
