package com.board.practice.react.board;

import com.board.practice.react.board.db.BoardEntity;
import com.board.practice.react.board.db.BoardMapper;
import com.board.practice.react.board.dto.BoardSaveDto;
import com.board.practice.react.board.util.Header;
import com.board.practice.react.board.util.Pagination;
import com.board.practice.react.board.util.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardMapper boardMapper;

    Header<List<BoardEntity>> getBoardList(int page, int size, Search search) {
        HashMap<String, Object> paramMap = new HashMap<>();

        if (page <= 1)
            paramMap.put("page", 0);
        else
            paramMap.put("page", (page - 1) * size);

        paramMap.put("size", size);
        paramMap.put("sk", search.getSk());
        paramMap.put("sv", search.getSv());

        List<BoardEntity> boardList = boardMapper.getBoardList(paramMap);
        Pagination pagination = new Pagination(
                boardMapper.getBoardTotalCount(paramMap),
                page,
                size,
                10
        );

        return Header.OK(boardList, pagination);
    }

    Header<BoardEntity> getBoardOne(Long idx) {
        return Header.OK(boardMapper.getBoardOne(idx));
    }

    Header<BoardEntity> insertBoard(BoardSaveDto boardSaveDto) {
        BoardEntity entity = boardSaveDto.toEntity();
        if (boardMapper.insertBoard(entity) > 0)
            return Header.OK(entity);
        else
            return Header.ERROR("ERROR");
    }

    Header<BoardEntity> updateBoard(BoardSaveDto boardSaveDto) {
        BoardEntity entity = boardSaveDto.toEntity();
        if (boardMapper.updateBoard(entity) > 0)
            return Header.OK(entity);
        else
            return Header.ERROR("ERROR");
    }

    Header<BoardEntity> deleteBoard(Long idx) {
        if (boardMapper.deleteBoard(idx) > 0)
            return Header.OK();
        else
            return Header.ERROR("ERROR");
    }
}
