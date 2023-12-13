package io.anichu.anichu.dto.response;

import io.anichu.anichu.entity.Anime;
import lombok.Builder;

@Builder
public class GetAnimeSummaryResponseDTO {
    private Long seq;
    private String name;
    private String score;
    private Integer commentCnt;
    private String companyName;

    public static GetAnimeSummaryResponseDTO from(Anime anime, AnimeAvgScoreDTO dto) {
        return GetAnimeSummaryResponseDTO.builder()
                .seq(anime.getSeq())
                .name(anime.getTitle())
                .score(String.format("%.1f", dto.getScore()))
                .commentCnt(dto.getCnt())
                .companyName(anime.getCompany().getName())
                .build();
    }
}
