package io.anichu.anichu.service;

import io.anichu.anichu.dto.response.GetTagResponseDTO;

import java.util.List;

public interface TagService {
    List<GetTagResponseDTO> getAllTags();
}
