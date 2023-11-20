package com.example.logintodohw.auth;

import com.example.logintodohw.jwt.JwtUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    public static final String AUTHORIZATION_HEADER="Authorization";
    private final JwtUtil jwtUtil;
    public AuthController(JwtUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }
    
    @GetMapping("/create-cookie")
    public String createCookie(HttpServletResponse res){
        addCookie("Jun Auth",res);
        return "createCookie";
    }

    private void addCookie(String junAuth, HttpServletResponse res) {
    }
}
