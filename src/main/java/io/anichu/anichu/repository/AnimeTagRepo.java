package io.anichu.anichu.repository;

import io.anichu.anichu.entity.AnimeTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeTagRepo extends JpaRepository<AnimeTag, Long> {
}
