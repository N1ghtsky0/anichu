package io.anichu.anichu.dto.response;

import io.anichu.anichu.entity.Anime;
import lombok.Builder;

import java.util.List;

@Builder
public class GetAnimeResponseDTO {
    private String name;
    private String summary;
    private String episodes;
    private String firstBroadcastDate;
    private String companyName;
    private Long companySeq;
    private List<String> tagList;

    public static GetAnimeResponseDTO from(Anime anime, List<String> tagList) {
        return GetAnimeResponseDTO.builder()
                .name(anime.getTitle())
                .summary(anime.getSummary())
                .episodes(anime.getTotalEpisode())
                .firstBroadcastDate(anime.getFirstBroadcastDate())
                .companyName(anime.getCompany().getName())
                .companySeq(anime.getCompany().getSeq())
                .tagList(tagList)
                .build();
    }
}
