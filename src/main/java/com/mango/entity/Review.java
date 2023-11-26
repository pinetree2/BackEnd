package com.mango.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Restaurant_Id")
    private Restaurant restaurant;

    @Column(name = "Score")
    private Boolean score;

    @Column(name = "Review_Contents")
    private String reviewContents;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewPicture> reviewPictures;


}

