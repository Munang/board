package com.example.demo.board.map;

import com.example.demo.board.domain.Board;

import java.util.List;

public interface BoardRepository {
    public Board getBoard(String Idx);

    public List<Board> getBoardList();
}
