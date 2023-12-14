package io.anichu.anichu.entity;

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
@Document(collection = "anime_tag")
public class AnimeTag {

    @Id
    private String animeName;

    private Long animeSeq;

    private String[] tagArr;

    public static AnimeTag from(Anime anime, String tags) {
        return AnimeTag.builder()
                .animeName(anime.getTitle())
                .animeSeq(anime.getSeq())
                .tagArr(tags.split(","))
                .build();
    }

}
