package io.anichu.anichu.vo;

import io.anichu.anichu.model.Anime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class AnimeVO {
    private Long seq;
    private String title;
    private String tags;
    private String broadCastDate;
    private String quarter;
    private String totalEpisodes;

    static public AnimeVO convert(Anime entity) {
        return AnimeVO.builder()
                .seq(entity.getSeq())
                .title(entity.getTitleKor())
                .broadCastDate(entity.getFirstBroadCastDate())
                .quarter(entity.getQuarter())
                .totalEpisodes(entity.getTotalEpisode())
                .build();
    }
}
