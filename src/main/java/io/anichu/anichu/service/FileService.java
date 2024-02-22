package io.anichu.anichu.service;

import io.anichu.anichu.model.Anime;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void uploadFile(Anime anime, MultipartFile file);
}
