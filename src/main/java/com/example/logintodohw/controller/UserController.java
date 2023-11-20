package com.example.logintodohw.controller;

import com.example.logintodohw.dto.LoginRequestDto;
import com.example.logintodohw.dto.SignupRequestDto;
import com.example.logintodohw.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){this.userService=userService;}

    @GetMapping("/user/login-page")
    public String loginPage(){return "login";}

    @GetMapping("/user/signup")
    public String signupPage(){return "signup";}

    @PostMapping("/user/signup")
    public String signup(@Valid SignupRequestDto signupRequestDto){
        userService.signup(signupRequestDto);
        return "redirect:/api/user/login-page";
    }

    @PostMapping("/user/login")
    public String login(LoginRequestDto loginRequestDto, HttpServletResponse res){
        try{
            userService.login(loginRequestDto,res);
        }catch (Exception e){
            return "redirect:/api/user/login-page?error";
        }
        return "redirect:/api/posts";
    }
}
