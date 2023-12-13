package io.anichu.anichu.service.impl;

import io.anichu.anichu.dto.response.GetAnimeSummaryResponseDTO;
import io.anichu.anichu.dto.response.GetTagResponseDTO;
import io.anichu.anichu.repository.AnimeRepo;
import io.anichu.anichu.repository.TagRepo;
import io.anichu.anichu.repository.mapper.AnimeTagMapper;
import io.anichu.anichu.service.CommentService;
import io.anichu.anichu.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagRepo tagRepo;
    private final AnimeRepo animeRepo;
    private final AnimeTagMapper animeTagMapper;
    private final CommentService commentService;

    @Override
    public List<GetTagResponseDTO> getAllTags() {
        return tagRepo.findAll().stream().map(GetTagResponseDTO::from).toList();
    }

    @Override
    public List<GetAnimeSummaryResponseDTO> getAllAnimeByTag(String[] tags) {
        return animeTagMapper.selectAllAnimeByTag(tags).stream()
                .map(seq -> animeRepo.findById(seq).orElseThrow())
                .map(anime -> GetAnimeSummaryResponseDTO.from(anime, commentService.getAnimeAverageScore(anime.getSeq())))
                .toList();
    }
}
