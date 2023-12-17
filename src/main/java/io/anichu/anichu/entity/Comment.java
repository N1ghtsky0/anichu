package io.anichu.anichu.entity;

import io.anichu.anichu.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer score;

    @ColumnDefault("false")
    private Boolean deleted;

    @ManyToOne
    private Anime anime;

}
