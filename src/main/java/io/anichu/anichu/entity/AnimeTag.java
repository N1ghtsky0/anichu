package io.anichu.anichu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

@Getter
@NoArgsConstructor
@Entity
public class AnimeTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    private Anime anime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tag tag;

    @Comment("true: 운영자 생성, false: 사용자 생성")
    @ColumnDefault("false")
    private Boolean type;

}
