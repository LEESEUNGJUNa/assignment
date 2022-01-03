package com.example.humelo.dto;

import com.example.humelo.model.post.Post;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostListRspDto {
    private List<String> userEmails;
    private List<String> titles;

    public PostListRspDto(List<Post> posts)
    {
        this.userEmails = new ArrayList<>();
        this.titles = new ArrayList<>();
        for (Post post:posts) {
            this.userEmails.add(post.getUser().getEmail());
            this.titles.add(post.getTitle());
        }
    }
}
