package com.board.practice.react.board;

import com.board.practice.react.board.db.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardMapper boardMapper;
}
