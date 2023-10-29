package com.mango.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
@Table(name = "Keywords")
public class Keywords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Key_Word")
    private String Keyword;

    @Column(name = "Key_Word_Cnt")
    private Long KeywordCnt;

    @OneToMany(mappedBy = "keywords")
    private List<RestaurantKeyword> restaurantKeywordList;

}
