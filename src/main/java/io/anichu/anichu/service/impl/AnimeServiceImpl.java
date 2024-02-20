package io.anichu.anichu.service.impl;

import io.anichu.anichu.model.middle.AnimeTag;
import io.anichu.anichu.repository.AnimeRepo;
import io.anichu.anichu.repository.AnimeTagRepo;
import io.anichu.anichu.service.AnimeService;
import io.anichu.anichu.vo.AnimeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnimeServiceImpl implements AnimeService {
    private final AnimeRepo animeRepo;
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
        return animeVO;
    }
}
