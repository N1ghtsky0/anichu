package io.anichu.anichu.repository.mapper;

import io.anichu.anichu.vo.AnimeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    List<String> selectAllTagsByAnime(AnimeVO vo);
}
