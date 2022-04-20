package com.example.demo.board.controller;

import com.example.demo.board.domain.Board;
import com.example.demo.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public @ResponseBody Board getBoard(@RequestParam String idx){
        return boardService.getBoard(idx);
    }

    @GetMapping("/boardlist")
    public @ResponseBody List<Board> getBoardList(){
        return boardService.getBoardList();
    }

    @PostMapping("/boardInsert")
    public String insertBoard(@RequestBody Board board){
        boardService.insertBoard(board);
        return "/board/hello";
    }

}
