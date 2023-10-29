package com.mango.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
@Table(name = "Restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Member_Id")
    private User user;

    @Column(name = "Restaurant_Name")
    private String RestaurantName;

    @Column(name = "Restaurant_Locate")
    private String RestaurantLocate;

    @Column(name = "Restaurant_Region")
    private String RestaurantRegion;

    @Column(name = "Restaurant_Phone")
    private String RestaurantPhone;

    @Column(name = "Restaurant_Menu")
    private String RestaurantMenu;

    @Column(name = "Restaurant_City")
    private String RestaurantCity;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantKeyword> restaurantKeywordList;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> restaurantReviewList;

}
