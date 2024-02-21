package io.anichu.anichu.repository;

import io.anichu.anichu.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepo extends JpaRepository<File, Long> {
    Optional<File> findByAnimeSeq(Long seq);
}
