package io.anichu.anichu.model.middle;

import io.anichu.anichu.model.Anime;
import io.anichu.anichu.model.Company;
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
@Comment("애니메이션-제작사 중간테이블")
@Entity
public class AnimeCompany extends BaseTimeEntity {
    @Comment("시퀀스")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @ManyToOne
    private Anime anime;

    @ManyToOne
    private Company company;
}
