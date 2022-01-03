package com.example.humelo.service;

import com.example.humelo.dto.LoginReqDto;
import com.example.humelo.dto.LoginRspDto;
import com.example.humelo.dto.SignupReqDto;
import com.example.humelo.dto.SignupRspDto;
import com.example.humelo.model.user.User;
import com.example.humelo.model.user.UserRepository;
import com.example.humelo.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public SignupRspDto SignUp(SignupReqDto requestDto) {
        SignupRspDto rspDto = new SignupRspDto();
        if(requestDto.getEmail().equals("") || requestDto.getPw().equals("") || userRepository.existsByEmail(requestDto.getEmail()))
        {
            rspDto.setMsg("fail");
        }
        else {
            requestDto.setPw(passwordEncoder.encode(requestDto.getPw()));
            User user = new User(requestDto);
            userRepository.save(user);
            rspDto.setMsg("success");
        }
        return rspDto;
    }

    public LoginRspDto Login(LoginReqDto requestDto) {
        LoginRspDto rsp = new LoginRspDto();
        User user = userRepository.findByEmail(requestDto.getEmail()).orElse(null);
        if (user == null)
            return null;
        if (!passwordEncoder.matches(requestDto.getPw(), user.getPw()))
            return null;
        rsp.setToken(jwtTokenProvider.createToken(user.getEmail(), user.getEmail()));
        rsp.setUserEmail(user.getEmail());
        return rsp;
    }
}
