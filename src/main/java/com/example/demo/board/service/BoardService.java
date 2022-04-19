package com.example.demo.board.service;

import com.example.demo.board.domain.Board;
import com.example.demo.board.map.BoardRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BoardService {
    /**
     * 1. 첫 번째 시도
     * 서비스 로직에 boardHashMap을 사용함
     * 문제점: 서비스 로직이 저장소가 바뀌면 전체 코드가 바뀌어야 하는 불상사
     * 결론: 서비스 로직이 저장소를 몰라야됨
     *
     * 2. 두 번째 시도
     * 서비스 로직을 인터페이스로 바꿈
     * 이유: 저장소가 바뀌면 다른 구현체를 쓰면 된다고 생각함
     * 문제점: 코드의 중복, 바꾸는 것이 아닌 새로 다시 만드는 방식임
     * 결론: 다르게 해야함
     *
     * 3. 세 번째 시도
     * BoardRepository를 인터페이스로 만듦
     * 이유: 어디에 저장할지에 대한 것을 서비스가 몰라야 하기 떄문
     * 장점: 모르게 됨(관심사의 분리)
     * 결론: 이렇게 하기로함
     * **/


    // 변하지 않는다는 걸 강조하기 위해 final을 사용
    public final BoardRepository boardRepository;

    /**
     * RequiredArgsConstructor: final로된 필드를 포함한 생성자를 자동으로 생성
     * Autowired를 안써도 되는 이유: Spring 규칙 상, 생성자가 1개면 자동적용
     * @param Idx
     * @return
     */

//    @Autowired
//    public BoardService(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }

    public Board getBoard(String Idx){
        return boardRepository.getBoard(Idx);
    }


    public List<Board> getBoardList(){
        return boardRepository.getBoardList();
    }

}
