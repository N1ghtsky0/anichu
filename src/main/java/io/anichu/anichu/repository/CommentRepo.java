package io.anichu.anichu.repository;

import io.anichu.anichu.entity.Anime;
import io.anichu.anichu.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findAllByAnimeAndDeletedFalse(Anime anime);
}
