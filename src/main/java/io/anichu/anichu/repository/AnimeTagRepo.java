package io.anichu.anichu.repository;

import io.anichu.anichu.model.middle.AnimeTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeTagRepo extends JpaRepository<AnimeTag, Long> {
    List<AnimeTag> findByAnimeSeq(Long seq);
}
