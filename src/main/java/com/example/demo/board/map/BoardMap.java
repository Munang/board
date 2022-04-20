package com.example.demo.board.map;

import com.example.demo.board.domain.Board;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BoardMap implements BoardRepository {

    // 되도록이면 인터페이스를 사용하는게 좋다. 왜냐면 나중에 HashMap이 아닌 다른 구현체를 사용하게 되면 교체가 가능
    // Dependency Inversion Principle = SOLI(D) -> 구현체 말고 인터페이스에 의존해라
    Map<String, Board> boardHashMap = new HashMap<>();

    @Override
    public Board getBoard(String Idx) {
        return boardHashMap.get(Idx);
    }

    @Override
    public List<Board> getBoardList() {
        List<Board> boards = new ArrayList<>();

        for (Board board: boardHashMap.values()
             ) {
            if (!board.getDeleteYn().equals("Y")){
                boards.add(board);
            }
        }
        // 이렇게 되면, 게시글이 1000개 100000개로 넘어가면 어떻게 하지?
        return boards;
    }

    @Override
    public void insertBoard(Board board) {
        // max 키 + 1 값으로 자동 인덱스 할당!
        String maxKey;
        if (boardHashMap.isEmpty()) {
            maxKey = "1";
        } else {
            maxKey = Collections.max(boardHashMap.keySet()) + 1;
        }
        boardHashMap.put(maxKey, board);
    }

    @Override
    public void deleteBoard(String Idx){
        for (String boardIdx: boardHashMap.keySet()
        ) {
            if (!boardIdx.equals(Idx)){
                boardHashMap.get(boardIdx).setDeleteYn("Y");
            }
        }
    }

}
