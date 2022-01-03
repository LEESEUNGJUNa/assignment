package com.example.humelo.service;

import com.example.humelo.dto.PostCreateReqDto;
import com.example.humelo.dto.PostCreateRspDto;
import com.example.humelo.dto.PostListRspDto;
import com.example.humelo.dto.PostReadRspDto;
import com.example.humelo.model.post.Post;
import com.example.humelo.model.post.PostRepository;
import com.example.humelo.model.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostReadRspDto GetPost(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null)
            return new PostReadRspDto(post);
        return null;
    }

    public PostListRspDto GetPosts() {
        List<Post> posts = postRepository.findAllByOrderByIdDesc();
        return new PostListRspDto(posts);
    }

    public PostCreateRspDto CreatePost(PostCreateReqDto requestDto, User user) {
        PostCreateRspDto rspDto = new PostCreateRspDto();
        Post post = new Post(requestDto,user);
        postRepository.save(post);
        rspDto.setMsg("success");
        return rspDto;
    }
}
