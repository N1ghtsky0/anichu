package io.anichu.anichu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer score;

    private Boolean deleted;

    @ManyToOne
    private Anime anime;

}
