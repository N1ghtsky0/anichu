package io.anichu.anichu.service;

import io.anichu.anichu.dto.response.*;

import java.util.HashMap;
import java.util.List;

public interface AnimeService {
    List<SearchAnimeResponseDTO> searchAnime(HashMap<String, Object> hashMap);

    List<GetAnimeSummaryResponseDTO> getAllAnimeSummaryCardByCompany(Long seq);

    GetAnimeResponseDTO getAnime(Long seq);

    PagingDTO paging(HashMap<String, Object> hashMap);

    List<AnimeCardResponseDTO> getTotalTop10();

    LatestQuarterTop10ResponseDTO getLatestQuarterTop10();

    TagTop10ResponseDTO getTagTop10WithOut(String tag);
}
