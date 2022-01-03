package com.example.humelo.controller;

import com.example.humelo.dto.LoginReqDto;
import com.example.humelo.dto.LoginRspDto;
import com.example.humelo.dto.SignupReqDto;
import com.example.humelo.dto.SignupRspDto;
import com.example.humelo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    public SignupRspDto registerUser(@RequestBody SignupReqDto requestDto) {
        return userService.SignUp(requestDto);
    }


    @PostMapping("/user/login")
    public LoginRspDto login(@RequestBody LoginReqDto requestDto){
        return userService.Login(requestDto);
    }

}
