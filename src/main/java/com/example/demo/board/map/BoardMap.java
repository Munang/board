package com.example.demo.board.map;

import com.example.demo.board.domain.Board;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BoardMap implements BoardRepository{

    // 되도록이면 인터페이스를 사용하는게 좋다. 왜냐면 나중에 HashMap이 아닌 다른 구현체를 사용하게 되면 교체가 가능
    // Dependency Inversion Principle = SOLI(D) -> 구현체 말고 인터페이스에 의존해라
    Map<String, Board> boardHashMap = new HashMap<>();

    @Override
    public Board getBoard(String Idx) {
        return boardHashMap.get(Idx);
    }

    @Override
    public List<Board> getBoardList() {
        List<Board> boards = boardHashMap.values().stream().toList();
        return boards;
    }

}
