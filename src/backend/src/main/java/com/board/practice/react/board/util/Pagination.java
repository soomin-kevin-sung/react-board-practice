package com.board.practice.react.board.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
    public Pagination(Integer totalListCnt, Integer page, Integer pageSize, Integer blockSize) {
        this.pageSize = pageSize;
        this.page = page;
        this.totalListCnt = totalListCnt;

        totalPageCnt = (int)Math.ceil(totalListCnt * 1.0 / this.pageSize);
        totalBlockCnt = (int)Math.ceil(totalPageCnt * 1.0 / blockSize);
        block = (int)Math.ceil(page * 1.0 / blockSize);

        startPage = (block - 1) * blockSize + 1;
        endPage = Math.min(totalPageCnt, startPage + blockSize - 1);

        prevBlock = Math.max(1, block * blockSize - blockSize);
        nextBlock = Math.min(totalPageCnt, block * blockSize + 1);

        startIndex = (this.page - 1) * this.pageSize;
    }

    // 페이지당 보여지는 게시글 최대 개수
    private int pageSize;

    // 현재 페이지
    int page;

    // 현재 블럭
    int block;

    // 총 게시글 수
    int totalListCnt;

    // 총 페이지 수
    int totalPageCnt;

    // 총 구간 수
    int totalBlockCnt;

    // 시작 페이지
    int startPage;

    // 마지막 페이지
    int endPage;

    // 이전구간 마지막 페이지
    int prevBlock;

    // 다음구간 시작 페이지
    int nextBlock;

    // 인덱스
    int startIndex;
}
