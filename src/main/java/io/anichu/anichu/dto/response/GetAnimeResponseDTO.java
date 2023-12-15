package io.anichu.anichu.dto.response;

import io.anichu.anichu.entity.Anime;
import lombok.Builder;

@Builder
public class GetAnimeResponseDTO {
    private String name;
    private String summary;
    private String episodes;
    private String firstBroadcastDate;
    private String companyName;
    private Long companySeq;

    public static GetAnimeResponseDTO from(Anime anime) {
        return GetAnimeResponseDTO.builder()
                .name(anime.getTitle())
                .summary(anime.getSummary())
                .episodes(anime.getTotalEpisode())
                .firstBroadcastDate(anime.getFirstBroadcastDate())
                .companyName(anime.getCompany().getName())
                .companySeq(anime.getCompany().getSeq())
                .build();
    }
}
