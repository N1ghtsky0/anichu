package io.anichu.anichu.model;

import io.anichu.anichu.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Comment("첨부 파일")
@Entity
public class File extends BaseTimeEntity {
    @Comment("시퀀스")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Comment("저장 경로")
    @Column(nullable = false)
    public String filePath;

    @Comment("저장 파일명")
    @Column(nullable = false, updatable = false, unique = true)
    private String fileName;

    @Comment("파일 크기")
    @Column(nullable = false)
    private Long fileSize;

    @Comment("원본 파일명")
    @Column(nullable = false, updatable = false)
    private String originName;

    @Comment("삭제 여부")
    @Builder.Default
    private Boolean isDeleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private Anime anime;
}
