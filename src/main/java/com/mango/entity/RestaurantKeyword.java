package com.mango.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
@Table(name = "RestaurantKeyword")
public class RestaurantKeyword {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Restaurant_Id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "Key_Word_Id")
    private Keywords keywords;
}
