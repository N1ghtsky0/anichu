package io.anichu.anichu.service.impl;

import io.anichu.anichu.dto.response.GetAnimeResponseDTO;
import io.anichu.anichu.dto.response.GetAnimeSummaryResponseDTO;
import io.anichu.anichu.dto.response.PagingDTO;
import io.anichu.anichu.dto.response.SearchAnimeResponseDTO;
import io.anichu.anichu.entity.Anime;
import io.anichu.anichu.entity.AnimeSearch;
import io.anichu.anichu.repository.AnimeRepo;
import io.anichu.anichu.repository.ProductionCompanyRepo;
import io.anichu.anichu.service.AnimeService;
import io.anichu.anichu.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AnimeServiceImpl implements AnimeService {
    private final AnimeRepo animeRepo;
    private final ProductionCompanyRepo productionCompanyRepo;
    private final CommentService commentService;
    private final MongoTemplate mongoTemplate;

    private final int CONTENT_IN_ONE_PAGE = 12;

    @Override
    public List<SearchAnimeResponseDTO> searchAnime(HashMap<String, Object> hashMap) {
        Query query = new Query();

        if (hashMap.get("tag") != null && !hashMap.get("tag").equals("")) {
            String tags = hashMap.get("tag").toString();
            query.addCriteria(new Criteria("tagArr").all((Object[]) tags.split(",")));
        }

        if (hashMap.get("company") != null && !hashMap.get("company").equals("")) {
            String company = hashMap.get("company").toString();
            query.addCriteria(new Criteria("companyName").is(company));
        }

        if (hashMap.get("page") != null && !hashMap.get("page").equals("")) {
            long page = Long.parseLong(hashMap.get("page").toString());
            query.skip(CONTENT_IN_ONE_PAGE * (page - 1)).limit(CONTENT_IN_ONE_PAGE);
        } else {
            query.limit(CONTENT_IN_ONE_PAGE);
        }

        return mongoTemplate.find(query, AnimeSearch.class).stream()
                .map(animeSearch -> animeRepo.findById(animeSearch.getAnimeSeq()).orElseThrow())
                .sorted(Comparator.comparing(Anime::getUpdateDate).reversed())
                .map(anime -> SearchAnimeResponseDTO.from(anime, commentService.getAnimeAverageScore(anime.getSeq())))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<GetAnimeSummaryResponseDTO> getAllAnimeSummaryCardByCompany(Long seq) {
        List<GetAnimeSummaryResponseDTO> responseDTO = new ArrayList<>();

        animeRepo.findAllByCompany(productionCompanyRepo.findById(seq).orElseThrow())
                .forEach(anime -> responseDTO.add(GetAnimeSummaryResponseDTO.from(anime, commentService.getAnimeAverageScore(anime.getSeq()))));

        return responseDTO;
    }

    @Override
    public List<GetAnimeSummaryResponseDTO> getRecommendAnimeSummaryCards() {
        return animeRepo.findAll().stream()
                .map(anime -> GetAnimeSummaryResponseDTO.from(anime, commentService.getAnimeAverageScore(anime.getSeq())))
                .sorted(Comparator.comparing(GetAnimeSummaryResponseDTO::getScore).reversed())
                .limit(10)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public GetAnimeResponseDTO getAnime(Long seq) {
        return GetAnimeResponseDTO.from(animeRepo.findById(seq).orElseThrow());
    }

    @Override
    public PagingDTO paging(HashMap<String, Object> hashMap) {
        if (hashMap.get("page") == null || hashMap.get("page").equals("")) {
            return PagingDTO.builder()
                    .pageNo(1)
                    .isLast(false)
                    .build();
        }

        long totalContents = mongoTemplate.findAll(AnimeSearch.class).size();
        long totalPages = totalContents / CONTENT_IN_ONE_PAGE;
        totalPages += (totalContents % CONTENT_IN_ONE_PAGE != 0) ? 1 : 0;
        return PagingDTO.builder()
                .totalPage(totalPages)
                .pageNo(Long.parseLong(hashMap.get("page").toString()))
                .isLast(Long.parseLong(hashMap.get("page").toString()) + 1 > totalPages)
                .build();
    }
}
