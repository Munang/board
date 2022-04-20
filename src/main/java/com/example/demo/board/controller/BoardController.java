package com.example.demo.board.controller;

import com.example.demo.board.domain.Board;
import com.example.demo.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/hello")
    public String Hello(){
        return "/board/hello";
    }

    // RequestParam -> 쓰는게 명확하고 좋다.
    @GetMapping("/board")
    @ResponseBody
    public Board getBoard(@RequestParam String idx){
        return boardService.getBoard(idx);
    }

    @GetMapping("/boardList")
    @ResponseBody
    public List<Board> getBoardList(){
        return boardService.getBoardList();
    }

    //RequestBody 말고 ModelAttribute도 사용함
    //리소스만 쓰는게 좋다. 동사는 피하는게 좋음 이게 restful하게 설계하는 것
    //동사를 쓸 수 밖에 없는 상황
    @PostMapping("/board")
    public ResponseEntity insertBoard(@RequestBody Board board){
        boardService.insertBoard(board);
        return new ResponseEntity(HttpStatus.CREATED);
        //result 메세지 보내는거 확인해두기 -> ReponseEntity
        // 201: Created 이게 더 명확!
    }

    @PostMapping("/boardDelete")
    public ResponseEntity deleteBoard(@RequestParam String idx){
        boardService.deleteBoard(idx);
        return new ResponseEntity(HttpStatus.OK);
    }

}
