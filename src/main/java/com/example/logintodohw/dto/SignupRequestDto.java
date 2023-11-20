package com.example.logintodohw.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {

    @NotNull(message = "username은 필수 입니다.")
    @Size(min = 4, max = 10, message = "4~10자 입력")
    @Pattern(regexp = "^[a-z0-9]*$", message = "알파벳 소문자(a~z), 숫자(0~9)만 입력 가능합니다.")
    private String username;

    @NotNull(message = "password은 필수 입니다.")
    @Size(min = 8, max = 15, message = "8~15자 입력")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "알파벳 대소문자(a~z, A~Z), 숫자(0~9)만 입력 가능합니다.")
    private String password;

    private String email;
    private boolean admin = false;
    private String adminToken = "";
}