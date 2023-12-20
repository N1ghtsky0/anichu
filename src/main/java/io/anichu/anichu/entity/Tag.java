package io.anichu.anichu.entity;

import io.anichu.anichu.base.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@NoArgsConstructor
@Entity
public class Tag extends BaseTimeEntity {

    @Id
    private String name;

    @ColumnDefault("false")
    private Boolean recommend;

}
