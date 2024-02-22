package io.anichu.anichu.repository;

import io.anichu.anichu.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag, String> {
    Boolean existsByName(String name);

    Tag findByName(String name);
}
