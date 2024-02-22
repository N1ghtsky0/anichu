package io.anichu.anichu.vo;

import io.anichu.anichu.model.File;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FileVO {
    private String filePath;
    private String fileName;
    private String originName;
    private Long fileSize;

    static public FileVO convert(File entity) {
        return FileVO.builder()
                .filePath(entity.getFilePath())
                .fileName(entity.getFileName())
                .originName(entity.getOriginName())
                .build();
    }
}
