package io.anichu.anichu.dto.response;

import io.anichu.anichu.entity.Anime;
import lombok.Builder;

@Builder
public class SearchAnimeResponseDTO {
    private Long animeSeq;
    private String animeName;
    private String companyName;
    private Float score;
    private Integer participants;

    public static SearchAnimeResponseDTO from(Anime anime, AnimeAvgScoreDTO dto) {
        return SearchAnimeResponseDTO.builder()
                .animeSeq(anime.getSeq())
                .animeName(anime.getTitle())
                .companyName(anime.getCompany().getName())
                .score(dto.getScore())
                .participants(dto.getCnt())
                .build();
    }
}
