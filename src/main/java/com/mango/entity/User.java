package com.mango.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "User_Token")
    private String userToken;

    @Column(name = "User_Pw")
    private String UserPw;

    @Column(name = "User_Nick")
    private String UserNick;

    //mappedBy 쓸때는 지정한 변수명
    @OneToMany(mappedBy = "user")
    private List<ReviewLike> reviewLikeList;

    @OneToMany(mappedBy = "user")
    private List<Restaurant> restaurantList;

    @OneToMany(mappedBy = "user")
    private List<SearchLog> searchLogList;


}
