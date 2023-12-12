package io.anichu.anichu.repository;

import io.anichu.anichu.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag, Long> {
}
