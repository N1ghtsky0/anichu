package io.anichu.anichu.repository;

import io.anichu.anichu.entity.Anime;
import io.anichu.anichu.entity.AnimeTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeTagRepo extends JpaRepository<AnimeTag, Long> {
    List<AnimeTag> findAllByAnime(Anime anime);
}
