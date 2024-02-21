package io.anichu.anichu.model;

import io.anichu.anichu.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@org.hibernate.annotations.Comment("평가, 평점")
@Entity
public class Comment extends BaseTimeEntity {
    @org.hibernate.annotations.Comment("시퀀스")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @org.hibernate.annotations.Comment("평가")
    @Column(nullable = false)
    private String content;

    @org.hibernate.annotations.Comment("평점")
    @Column(nullable = false)
    private Integer score;

    @org.hibernate.annotations.Comment("공감, 좋아요")
    @Column(nullable = false)
    @Builder.Default
    private Long likeCnt = 0L;

    @ManyToOne
    private Anime anime;

    @ManyToOne
    private User user;
}
