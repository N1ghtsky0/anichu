package io.anichu.anichu.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimeSearchRequestDTO {
    private String sTag;
    private String sCompany;
    private String sSort;
    private String sKeyword;
    private String page;
}
