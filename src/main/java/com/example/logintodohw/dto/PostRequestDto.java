package com.example.logintodohw.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private Long id;
    private String title;
    private String contents;
    private String date;
    private String username;
    private boolean complete = false;//완료 여부
}
