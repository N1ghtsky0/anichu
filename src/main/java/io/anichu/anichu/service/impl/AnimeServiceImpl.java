package io.anichu.anichu.service.impl;

import io.anichu.anichu.dto.response.GetAnimeSummaryResponseDTO;
import io.anichu.anichu.repository.AnimeRepo;
import io.anichu.anichu.repository.ProductionCompanyRepo;
import io.anichu.anichu.service.AnimeService;
import io.anichu.anichu.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AnimeServiceImpl implements AnimeService {
    private final AnimeRepo animeRepo;
    private final ProductionCompanyRepo productionCompanyRepo;
    private final CommentService commentService;

    @Override
    @Transactional(readOnly = true)
    public List<GetAnimeSummaryResponseDTO> getAllAnimeSummaryCardByCompany(Long seq) {
        List<GetAnimeSummaryResponseDTO> responseDTO = new ArrayList<>();

        animeRepo.findAllByCompany(productionCompanyRepo.findById(seq).orElseThrow())
                .forEach(anime -> responseDTO.add(GetAnimeSummaryResponseDTO.from(anime, commentService.getAnimeAverageScore(anime))));

        return responseDTO;
    }
}
