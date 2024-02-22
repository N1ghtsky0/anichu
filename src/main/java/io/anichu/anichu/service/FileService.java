package io.anichu.anichu.service;

import io.anichu.anichu.model.Anime;
import io.anichu.anichu.vo.AnimeVO;
import io.anichu.anichu.vo.FileVO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void uploadFile(Anime anime, MultipartFile file);

    FileVO getFileByAnime(AnimeVO vo);
}
