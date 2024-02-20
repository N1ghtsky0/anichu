package io.anichu.anichu.model;

import io.anichu.anichu.util.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Comment("장르, 태그")
@Entity
public class Tag extends BaseTimeEntity {
    @Comment("장르-태그명")
    @Id
    private String name;
}
