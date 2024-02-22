package io.anichu.anichu.service.impl;

import io.anichu.anichu.model.Anime;
import io.anichu.anichu.repository.FileRepo;
import io.anichu.anichu.service.FileService;
import io.anichu.anichu.vo.FileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {
    @Value("${resource.upload}")
    private String UPLOAD_DIR;

    private final FileRepo fileRepo;

    @Override
    public void uploadFile(Anime anime, MultipartFile file) {
        FileVO uploadedFile = saveFile(file);
        fileRepo.save(io.anichu.anichu.model.File.builder()
                .filePath(uploadedFile.getFilePath())
                .fileName(uploadedFile.getFileName())
                .originName(uploadedFile.getOriginName())
                .fileSize(uploadedFile.getFileSize())
                .anime(anime)
                .build());
    }

    private FileVO saveFile(MultipartFile multipartFile) {
        FileVO fileVO = new FileVO();
        try {
            String fileName = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
            File file = new File(UPLOAD_DIR + fileName);
            multipartFile.transferTo(file);

            fileVO.setFilePath(UPLOAD_DIR);
            fileVO.setFileName(file.getName());
            fileVO.setOriginName(multipartFile.getOriginalFilename());
            fileVO.setFileSize(multipartFile.getSize());
        } catch (Exception e) {
            log.error(String.format("{%s} 파일 저장 오류", multipartFile.getOriginalFilename()));
            log.error(e.getMessage());
        }
        return fileVO;
    }
}
