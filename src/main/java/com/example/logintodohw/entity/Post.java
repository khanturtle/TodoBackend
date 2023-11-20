package com.example.logintodohw.entity;

import com.example.logintodohw.dto.PostRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Post {
    private Long id;
    private String title;
    private String contents;
    private String date;
    private String username;
    private boolean complete = false;//완료 여부

    public Post(PostRequestDto requestDto) {
        this.id = requestDto.getId();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.date = requestDto.getDate();
        this.username = requestDto.getUsername();
        this.complete = requestDto.isComplete();    //boolean getter는 is___
    }

    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
