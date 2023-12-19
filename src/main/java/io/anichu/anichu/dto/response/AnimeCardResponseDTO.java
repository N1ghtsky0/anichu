package io.anichu.anichu.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;

@Builder
@Getter
public class AnimeCardResponseDTO {
    private Long animeSeq;
    private String animeTitle;
    private String score;
    private Long evaluationCnt;
    private String companyName;

    public static AnimeCardResponseDTO from(HashMap<String, Object> hashMap) {
        return AnimeCardResponseDTO.builder()
                .animeSeq((long) hashMap.get("animeSeq"))
                .animeTitle((String) hashMap.get("animeTitle"))
                .score(String.format("%.2f", ((BigDecimal) hashMap.get("score")).floatValue()))
                .evaluationCnt((long) hashMap.get("evaluationCnt"))
                .companyName((String) hashMap.get("companyName"))
                .build();
    }
}
