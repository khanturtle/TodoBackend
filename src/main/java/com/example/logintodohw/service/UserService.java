package com.example.logintodohw.service;

import com.example.logintodohw.dto.LoginRequestDto;
import com.example.logintodohw.dto.SignupRequestDto;
import com.example.logintodohw.entity.User;
import com.example.logintodohw.jwt.JwtUtil;
import com.example.logintodohw.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // ADMIN_TOKEN
    private final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    public void signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = passwordEncoder.encode(requestDto.getPassword());

        // 회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        // email 중복확인
        String email = requestDto.getEmail();
        Optional<User> checkEmail = userRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 Email 입니다.");
        }

        // 사용자 등록
        User user = new User(username, password, email);
        userRepository.save(user);
    }

    public void login(LoginRequestDto loginRequestDto, HttpServletResponse res) {
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록되지 않은 사용자 입니다.")
        );
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        String token = jwtUtil.createToken(user.getUsername());
        jwtUtil.addJwtToCookie(token, res);
    }
}