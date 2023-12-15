package io.anichu.anichu.service;

import io.anichu.anichu.dto.response.GetAnimeResponseDTO;
import io.anichu.anichu.dto.response.GetAnimeSummaryResponseDTO;
import io.anichu.anichu.dto.response.PagingDTO;
import io.anichu.anichu.dto.response.SearchAnimeResponseDTO;

import java.util.HashMap;
import java.util.List;

public interface AnimeService {
    List<SearchAnimeResponseDTO> searchAnime(HashMap<String, Object> hashMap);

    List<GetAnimeSummaryResponseDTO> getAllAnimeSummaryCardByCompany(Long seq);

    List<GetAnimeSummaryResponseDTO> getRecommendAnimeSummaryCards();

    GetAnimeResponseDTO getAnime(Long seq);

    PagingDTO paging(HashMap<String, Object> hashMap);
}
