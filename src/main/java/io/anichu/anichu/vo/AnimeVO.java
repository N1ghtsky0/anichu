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
    private String titleOrigin;
    private String titleKor;
    private String tags;
    private String broadCastDate;
    private String quarter;
    private String totalEpisodes;
    private FileVO fileVO;

    static public AnimeVO convert(Anime entity) {
        return AnimeVO.builder()
                .seq(entity.getSeq())
                .titleKor(entity.getTitleKor())
                .broadCastDate(entity.getFirstBroadCastDate())
                .quarter(entity.getQuarter())
                .totalEpisodes(entity.getTotalEpisode())
                .build();
    }

    public Anime toEntity() {
        return Anime.builder()
                .titleOrigin(getTitleOrigin())
                .titleKor(getTitleKor())
                .quarter(getQuarter())
                .firstBroadCastDate(getBroadCastDate())
                .totalEpisode(getTotalEpisodes())
                .build();
    }
}
