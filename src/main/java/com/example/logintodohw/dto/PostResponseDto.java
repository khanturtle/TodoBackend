package com.example.logintodohw.dto;

import com.example.logintodohw.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String date;
    private String username;
    private boolean complete = false;//완료 여부

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.username = post.getUsername();
        this.contents = post.getContents();
        this.date = post.getDate();
        this.complete = post.isComplete();
    }

    public PostResponseDto(Long id, String username, String contents) {
    }
}
