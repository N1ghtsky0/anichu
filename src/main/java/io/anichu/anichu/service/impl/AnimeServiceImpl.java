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

        //todo 태그들을 문자열로 바꾸는 로직이 해당 매서드에서 필요한지 다시 생각해보기
        //todo substring 외에 더 깔끔하게 합치는 방법 생각해보기
        StringBuilder tagStr = new StringBuilder();
        for (AnimeTag animeTag : animeTagRepo.findByAnimeSeq(animeVO.getSeq())) {
            tagStr.append(", ").append(animeTag.getTag().getName());
        }
        animeVO.setTags(tagStr.substring(2));

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
