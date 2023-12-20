package io.anichu.anichu.repository;

import io.anichu.anichu.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepo extends JpaRepository<Tag, Long> {
    List<Tag> findAllByRecommendIsTrue();
}
