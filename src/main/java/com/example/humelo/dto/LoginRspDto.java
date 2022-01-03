package com.example.humelo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LoginRspDto {
    private String token;
    private String userEmail;
}
