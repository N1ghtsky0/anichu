package io.anichu.anichu.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "anime")
public class AnimeSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String animeName;

    private Long animeSeq;

    private String companyName;

    private Long companySeq;

    private String[] tagArr;

    public static AnimeSearch from(Anime anime, String tags) {
        return AnimeSearch.builder()
                .animeName(anime.getTitle())
                .animeSeq(anime.getSeq())
                .companyName(anime.getCompany().getName())
                .companySeq(anime.getCompany().getSeq())
                .tagArr(tags.split(","))
                .build();
    }

}
