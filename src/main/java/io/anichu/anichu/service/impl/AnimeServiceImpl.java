package io.anichu.anichu.service.impl;

import io.anichu.anichu.dto.response.*;
import io.anichu.anichu.entity.Anime;
import io.anichu.anichu.entity.AnimeSearch;
import io.anichu.anichu.entity.Tag;
import io.anichu.anichu.repository.AnimeRepo;
import io.anichu.anichu.repository.AnimeTagRepo;
import io.anichu.anichu.repository.ProductionCompanyRepo;
import io.anichu.anichu.repository.TagRepo;
import io.anichu.anichu.repository.mapper.AnimeMapper;
import io.anichu.anichu.repository.mapper.AnimeTagMapper;
import io.anichu.anichu.service.AnimeService;
import io.anichu.anichu.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
public class AnimeServiceImpl implements AnimeService {
    private final AnimeRepo animeRepo;
    private final TagRepo tagRepo;
    private final AnimeTagRepo animeTagRepo;
    private final ProductionCompanyRepo productionCompanyRepo;
    private final AnimeMapper animeMapper;
    private final AnimeTagMapper animeTagMapper;
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
    @Transactional(readOnly = true)
    public GetAnimeResponseDTO getAnime(Long seq) {
        Anime anime = animeRepo.findById(seq).orElseThrow();
        List<String> tagList = animeTagRepo.findAllByAnime(anime).stream()
                .map(animeTag -> animeTag.getTag().getName())
                .toList();
        return GetAnimeResponseDTO.from(anime, tagList);
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

    @Override
    @Transactional(readOnly = true)
    public List<AnimeCardResponseDTO> getTotalTop10() {
        return animeMapper.selectTotalTop10().stream()
                .map(AnimeCardResponseDTO::from)
                .sorted(Comparator
                        .comparing(AnimeCardResponseDTO::getScore)
                        .thenComparing(AnimeCardResponseDTO::getEvaluationCnt).reversed())
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public LatestQuarterTop10ResponseDTO getLatestQuarterTop10() {
        String quarter = animeMapper.selectLatestQuarter();
        return LatestQuarterTop10ResponseDTO.from(quarter, animeMapper.selectLatestQuarterTop10(quarter));
    }

    @Override
    public TagTop10ResponseDTO getTagTop10WithOut(String tag) {
        String targetTag;
        List<Tag> tagList = tagRepo.findAllByRecommendIsTrue();

        do {    //입력된 태그명과 다른 태그가 뽑힐 때까지 반복
            int randomIndex = new Random().nextInt(tagList.size());
            targetTag = tagList.get(randomIndex).getName();
        } while (Objects.equals(tag, targetTag));
        
        return TagTop10ResponseDTO.from(targetTag, animeTagMapper.selectTop10ByTag(targetTag));
    }

}
