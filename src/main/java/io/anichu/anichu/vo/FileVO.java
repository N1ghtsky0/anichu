package io.anichu.anichu.vo;

import io.anichu.anichu.model.File;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class FileVO {
    private String filePath;
    private String fileName;
    private String originName;

    static public FileVO convert(File entity) {
        return FileVO.builder()
                .filePath(entity.getFilePath())
                .fileName(entity.getFileName())
                .originName(entity.getOriginName())
                .build();
    }
}
