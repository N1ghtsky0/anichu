package io.anichu.anichu.service.impl;

import io.anichu.anichu.dto.response.GetAnimeSummaryResponseDTO;
import io.anichu.anichu.dto.response.GetTagResponseDTO;
import io.anichu.anichu.entity.AnimeSearch;
import io.anichu.anichu.repository.AnimeRepo;
import io.anichu.anichu.repository.TagRepo;
import io.anichu.anichu.service.CommentService;
import io.anichu.anichu.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagRepo tagRepo;
    private final AnimeRepo animeRepo;
    private final CommentService commentService;
    private final MongoTemplate mongoTemplate;

    @Override
    @Transactional(readOnly = true)
    public List<GetTagResponseDTO> getAllTags() {
        return tagRepo.findAll().stream().map(GetTagResponseDTO::from).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<GetAnimeSummaryResponseDTO> getAllAnimeByTag(String[] tags) {
        Criteria criteria = Criteria.where("tagArr").all((Object[]) tags);
        Query query = new Query(criteria);

        return mongoTemplate.find(query, AnimeSearch.class).stream()
                .map(animeSearch -> animeRepo.findById(animeSearch.getAnimeSeq()).orElseThrow())
                .map(anime -> GetAnimeSummaryResponseDTO.from(anime, commentService.getAnimeAverageScore(anime.getSeq())))
                .toList();
    }
}
