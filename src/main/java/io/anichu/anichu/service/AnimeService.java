package io.anichu.anichu.service;

import io.anichu.anichu.dto.response.GetAnimeResponseDTO;
import io.anichu.anichu.dto.response.GetAnimeSummaryResponseDTO;

import java.util.List;

public interface AnimeService {
    List<GetAnimeSummaryResponseDTO> getAllAnimeSummaryCardByCompany(Long seq);

    GetAnimeResponseDTO getAnime(Long seq);
}
