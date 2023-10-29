package com.mango.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
@Table(name = "ReviewLike")
public class ReviewLike {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Member_Id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Review_Id")
    private Review review;



}
