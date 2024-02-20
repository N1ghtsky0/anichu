package io.anichu.anichu.repository;

import io.anichu.anichu.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimeRepo extends JpaRepository<Anime, Long> {
    Optional<Anime> findByTitleKor(String title);
}
