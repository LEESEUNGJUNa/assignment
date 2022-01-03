package com.example.humelo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCreateReqDto {
    private String title;
    private String content;
}
