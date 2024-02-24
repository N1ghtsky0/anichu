package io.anichu.anichu.service.impl;

import io.anichu.anichu.model.Anime;
import io.anichu.anichu.model.Tag;
import io.anichu.anichu.model.middle.AnimeTag;
import io.anichu.anichu.repository.AnimeRepo;
import io.anichu.anichu.repository.AnimeTagRepo;
import io.anichu.anichu.repository.TagRepo;
import io.anichu.anichu.service.AnimeService;
import io.anichu.anichu.service.FileService;
import io.anichu.anichu.vo.AnimeVO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnimeServiceImpl implements AnimeService {
    private final AnimeRepo animeRepo;
    private final TagRepo tagRepo;
    private final FileService fileService;
    private final AnimeTagRepo animeTagRepo;

    @Override
    public AnimeVO getAnimeDetailByTitle(String title) {
        AnimeVO animeVO = AnimeVO.convert(animeRepo.findByTitleKor(title).orElseThrow(
                () -> new RuntimeException(String.format("{%s} 애니메이션을 찾을 수 없습니다.", title))));

        List<String> tagList = animeTagRepo.findByAnimeSeq(animeVO.getSeq()).stream()
                .map(animeTag -> animeTag.getTag().getName())
                .toList();
        String tagString = String.join(", ", tagList);
        animeVO.setTags(tagString);

        animeVO.setFileVO(fileService.getFileByAnime(animeVO));
        return animeVO;
    }

    @Override
    public AnimeVO getAnimeDetailBySeq(Long seq) {
        return AnimeVO.convert(animeRepo.findBySeq(seq).orElseThrow(
                () -> new RuntimeException(String.format("Seq-{%d} 애니메이션을 찾을 수 없습니다.", seq))));
    }

    @Override
    @Transactional
    public void insertAnime(AnimeVO vo, MultipartFile file) {
        Anime anime = animeRepo.save(vo.toEntity());
        fileService.uploadFile(anime, file);

        for (String tagStr : vo.getTags().split(",")) {
            Tag tag = (tagRepo.existsByName(tagStr)) ? tagRepo.findByName(tagStr) : tagRepo.save(Tag.builder().name(tagStr).build());
            animeTagRepo.save(AnimeTag.builder()
                    .anime(anime)
                    .tag(tag)
                    .build());
        }
    }
}
