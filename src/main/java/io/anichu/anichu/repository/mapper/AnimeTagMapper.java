package io.anichu.anichu.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnimeTagMapper {
    List<Long> selectAllAnimeByTag(String[] tags);
}
