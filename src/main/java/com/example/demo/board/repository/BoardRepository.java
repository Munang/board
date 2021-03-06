package com.example.demo.board.repository;

import com.example.demo.board.domain.Board;

import java.util.List;

public interface BoardRepository {
    public Board getBoard(String Idx);

    public List<Board> getBoardList();

    public void insertBoard(Board board);

    public void deleteBoard(String Idx);
}
