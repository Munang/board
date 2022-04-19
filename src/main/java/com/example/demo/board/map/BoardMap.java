package com.example.demo.board.map;

import com.example.demo.board.domain.Board;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class BoardMap implements BoardRepository{

    HashMap<String, Board> boardHashMap = new HashMap<>();

    @Override
    public Board getBoard(String Idx) {
        return boardHashMap.get(Idx);

    }
}
