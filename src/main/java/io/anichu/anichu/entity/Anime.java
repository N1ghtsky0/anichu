package io.anichu.anichu.entity;

import io.anichu.anichu.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@NoArgsConstructor
@Entity
public class Anime extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Comment("애니메이션 제목")
    @Column(nullable = false)
    private String title;

    @Comment("애니메이션 내용 요약")
    @Column(length = 1000)
    private String summary;

    @Comment("총 회차수")
    private String totalEpisode;

    @Comment("첫 방영일")
    private String firstBroadcastDate;

    @Comment("방영 분기")
    private String quarter;

    @ManyToOne
    private ProductionCompany company;

}
