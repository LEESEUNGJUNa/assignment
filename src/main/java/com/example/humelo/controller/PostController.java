package com.example.humelo.controller;

import com.example.humelo.dto.PostCreateReqDto;
import com.example.humelo.dto.PostCreateRspDto;
import com.example.humelo.dto.PostListRspDto;
import com.example.humelo.dto.PostReadRspDto;
import com.example.humelo.model.post.Post;
import com.example.humelo.security.UserDetailsImpl;
import com.example.humelo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/createpost")
    public PostCreateRspDto createPost(
            @RequestBody PostCreateReqDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails == null)
            return null;
        return postService.CreatePost(requestDto,userDetails.getUser());
    }
    @GetMapping("/getpost/{id}")
    public PostReadRspDto getPost(@PathVariable Long id)
    {
        PostReadRspDto rsp = postService.GetPost(id);
        return rsp;
    }

    @GetMapping("/getpostlist")
    public PostListRspDto getPosts()
    {
        return postService.GetPosts();
    }

}
