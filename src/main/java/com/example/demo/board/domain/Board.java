package com.example.demo.board.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Board {
    private Long boardId;
    private String title;
    private String content;
    private String name;
    private LocalDateTime createDate;
    private int viewCount;
    private Boolean valid=Boolean.TRUE;
    private Long memberId;

//     getIsValid를 사용하게 하지 않기 위해 별도로 함수 구현
    public Boolean isValid(){
        return this.valid;
    }

}
