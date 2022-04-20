package com.example.demo.board.repository;

import com.example.demo.board.domain.Board;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.util.*;

// 스프링은 싱글톤
// 내가 요청을 보내던 준걸이가 요청을 보내던 같은 객체가 사용됨
// 처음에 컨테이너에 올릴때 올린 객체를 계속 다른사람이 이용하는 것
// 시퀀스를 만들기

@Component
public class BoardMemoryRepository implements BoardRepository {

    // 되도록이면 인터페이스를 사용하는게 좋다. 왜냐면 나중에 HashMap이 아닌 다른 구현체를 사용하게 되면 교체가 가능
    // Dependency Inversion Principle = SOLI(D) -> 구현체 말고 인터페이스에 의존해라
    Map<String, Board> boardHashMap = new HashMap<>();
    // 시퀀스가 유지된다. 모든 유저가 한 객체를 사용하기 때문에
    // 실제로 이런 개념이 사용되지는 않는다.
    // unique하게 시퀀스를 사용할 수 있다.
    Integer sequence = 0;

    @Override
    public Board getBoard(String idx) {
        if (boardHashMap.containsKey(idx)) {
            return boardHashMap.get(idx);
        }
        throw new InvalidParameterException();
    }

    @Override
    public List<Board> getBoardList() {
        // iter(단축키) 루프 단축키!! boardHashMap.values().iter/ iter(이터레이터)
        return boardHashMap.values().stream()
                .filter(Board::isValid)
                .toList();
    }

    @Override
    public void insertBoard(Board board) {
        // max 키 + 1 값으로 자동 인덱스 할당!
        boardHashMap.put(String.valueOf(sequence++), board);
    }

    @Override
    public void deleteBoard(String idx){
        if(boardHashMap.containsKey(idx)){
            boardHashMap.get(idx).setValid(Boolean.FALSE);
            // get idx 했을 때 없으면 null -> 여기에 셋 밸리드 하면 널포인트 익셉션 나온다.
            // 당굴당이라면, get(idx)하고 맨 윗줄에 객체로 담는다.
        }
        throw new InvalidParameterException();
    }

}
