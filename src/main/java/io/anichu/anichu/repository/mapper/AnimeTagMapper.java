package io.anichu.anichu.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AnimeTagMapper {
    List<HashMap<String, Object>> selectTop10ByTag(String tag);
}
