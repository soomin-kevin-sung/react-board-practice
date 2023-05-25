package com.board.practice.react.board.db;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardEntity> getBoardList();
}
