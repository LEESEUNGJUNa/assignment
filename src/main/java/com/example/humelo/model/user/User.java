package com.example.humelo.model.user;

import com.example.humelo.dto.SignupReqDto;
import com.example.humelo.model.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String pw;

    @OneToMany(mappedBy = "user")
    private List<Post> post;

    public User(SignupReqDto requestDto) {
        this.email = requestDto.getEmail();
        this.pw = requestDto.getPw();
    }
}
