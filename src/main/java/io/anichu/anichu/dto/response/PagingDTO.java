package io.anichu.anichu.dto.response;

import lombok.Builder;

@Builder
public class PagingDTO {
    private long totalPage;
    private long pageNo;
    private boolean isLast;
}
