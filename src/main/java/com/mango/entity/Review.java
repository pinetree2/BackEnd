package com.mango.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Builder
@RequiredArgsConstructor
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Restaurant_Id")
    private Restaurant restaurant;

    @Column(name = "Score")
    private boolean score;

    @Column(name = "Review_Contents")
    private String reviewContents;


}

