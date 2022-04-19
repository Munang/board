package com.example.demo.board.controller;

import com.example.demo.board.domain.Board;
import com.example.demo.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class BoardController {

    BoardService boardService;

    @GetMapping("/hello")
    public String Hello(){
        return "/board/hello";
    }

    // RequestParam -> 쓰는게 명확하고 좋다.
    @GetMapping("/board")
    public Board getBoard(@RequestParam String idx){
        return boardService.getBoard(idx);
    }

    @GetMapping("/boardlist")
    public List<Board> getBoardList(){
        return boardService.getBoardList();
    }


}
