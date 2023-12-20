package io.anichu.anichu.repository;

import io.anichu.anichu.entity.Anime;
import io.anichu.anichu.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    Page<Comment> findAllByAnimeAndDeletedFalse(Anime anime, Pageable pageable);
}
