package com.example.humelo.model.post;

import com.example.humelo.dto.PostCreateReqDto;
import com.example.humelo.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Post(PostCreateReqDto requestDto, User user)
    {
        this.user = user;
        this.title = requestDto.getTitle();
        this.content=requestDto.getContent();
    }
}
