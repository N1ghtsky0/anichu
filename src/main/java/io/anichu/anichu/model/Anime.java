package io.anichu.anichu.model;

import io.anichu.anichu.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Comment("애니메이션")
@Entity
public class Anime extends BaseTimeEntity {
    @Comment("애니메이션 시퀀스")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Comment("애니메이션 원제")
    @Column(nullable = false)
    private String titleOrigin;

    @Comment("애니메이션 제목 - 한글")
    @Column(nullable = false)
    private String titleKor;

    @Comment("애니메이션 줄거리")
    @Column(length = 1023)
    private String summary;

    @Comment("작품 방영 분기")
    private String quarter;

    @Comment("첫 방영일")
    private String firstBroadCastDate;

    @Comment("총 회차수")
    private String totalEpisode;
}
