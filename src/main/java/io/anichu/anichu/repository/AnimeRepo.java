package io.anichu.anichu.repository;

import io.anichu.anichu.entity.Anime;
import io.anichu.anichu.entity.ProductionCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepo extends JpaRepository<Anime, Long> {
    List<Anime> findAllByCompany(ProductionCompany company);
}
