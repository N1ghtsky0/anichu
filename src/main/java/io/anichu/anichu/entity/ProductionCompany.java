package io.anichu.anichu.entity;

import io.anichu.anichu.base.BaseTimeEntity;
import io.anichu.anichu.dto.request.InsertCompanyRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductionCompany extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(nullable = false)
    private String name;

    public static ProductionCompany from(InsertCompanyRequestDTO requestDTO) {
        return ProductionCompany.builder()
                .name(requestDTO.getName())
                .build();
    }
}
