package io.anichu.anichu.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AnimeMapper {
    String selectLatestQuarter();

    List<HashMap<String, Object>> selectTotalTop10();

    List<HashMap<String, Object>> selectLatestQuarterTop10(String quarter);

}
