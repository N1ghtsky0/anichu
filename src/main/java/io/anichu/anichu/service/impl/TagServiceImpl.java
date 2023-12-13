package io.anichu.anichu.service.impl;

import io.anichu.anichu.dto.response.GetTagResponseDTO;
import io.anichu.anichu.repository.TagRepo;
import io.anichu.anichu.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagRepo tagRepo;

    @Override
    public List<GetTagResponseDTO> getAllTags() {
        return tagRepo.findAll().stream().map(GetTagResponseDTO::from).toList();
    }
}
