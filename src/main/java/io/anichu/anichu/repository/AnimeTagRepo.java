package io.anichu.anichu.repository;

import io.anichu.anichu.entity.AnimeTag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimeTagRepo extends MongoRepository<AnimeTag, Long> {
}
