package com.example.humelo.dto;

import com.example.humelo.model.post.Post;
import lombok.Data;


@Data
public class PostReadRspDto {
    private String userEmail;
    private String content;
    private String title;
    public PostReadRspDto(Post post)
    {
        this.userEmail = post.getUser().getEmail();
        this.content = post.getContent();
        this.title = post.getTitle();
    }

}
