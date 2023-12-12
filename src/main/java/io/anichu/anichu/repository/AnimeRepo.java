package io.anichu.anichu.repository;

import io.anichu.anichu.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepo extends JpaRepository<Anime, Long> {
}
