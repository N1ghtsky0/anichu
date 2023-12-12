package io.anichu.anichu.service.impl;

import io.anichu.anichu.dto.request.InsertCompanyRequestDTO;
import io.anichu.anichu.dto.response.GetCompanyResponseDTO;
import io.anichu.anichu.entity.ProductionCompany;
import io.anichu.anichu.repository.ProductionCompanyRepo;
import io.anichu.anichu.service.ProductionCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionCompanyServiceImpl implements ProductionCompanyService {
    private final ProductionCompanyRepo productionCompanyRepo;

    @Override
    public void insertProductCompany(InsertCompanyRequestDTO requestDTO) {
        productionCompanyRepo.save(ProductionCompany.from(requestDTO));
    }

    @Override
    public GetCompanyResponseDTO getProductionCompany(Long seq) {
        return GetCompanyResponseDTO.from(productionCompanyRepo.findById(seq).orElseThrow());
    }

    @Override
    public List<GetCompanyResponseDTO> getAllProductionCompany() {
        return productionCompanyRepo.findAll().stream()
                .map(GetCompanyResponseDTO::from)
                .toList();
    }
}
