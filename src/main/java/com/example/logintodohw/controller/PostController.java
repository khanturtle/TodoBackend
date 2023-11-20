package com.example.logintodohw.controller;

import com.example.logintodohw.dto.PostRequestDto;
import com.example.logintodohw.dto.PostResponseDto;
import com.example.logintodohw.entity.Post;
import com.example.logintodohw.service.PostService;
import io.jsonwebtoken.Header;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class PostController {
    private final JdbcTemplate jdbcTemplate;

    public PostController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        PostService postService = new PostService(jdbcTemplate);
        return postService.createPost(requestDto);
    }

    @GetMapping("/posts")
    public List<PostResponseDto> getPosts(){
        PostService postService= new PostService(jdbcTemplate);
        return postService.getPosts();
    }
    @PutMapping("/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        PostService postService= new PostService(jdbcTemplate);
        return postService.updatePost(id,requestDto);
    }
    @DeleteMapping("/posts/{id}")
    public Long deletePost(@PathVariable Long id){
        PostService postService = new PostService(jdbcTemplate);
        return postService.deletePost(id);
    }
}
