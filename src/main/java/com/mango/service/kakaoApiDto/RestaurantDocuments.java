package com.mango.service.kakaoApiDto;

import com.mango.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDocuments {

    private String address_name;
    private String category_group_code;
    private String category_group_name;
    private String category_name;
    private Long distance;
    private Long id;
    private String phone;
    private String place_name;
    private String place_url;
    private String road_address_name;
    public Double x;
    public Double y;

    public Restaurant documentsToEntity(){
        return Restaurant.builder()
            .id(this.id)
            .address_name(this.address_name)
            .road_address_name(this.road_address_name)
            .category_name(this.category_name)
            .phone(this.phone)
            .place_name(this.place_name)
            .place_url(this.place_url)
            .x(this.x)
            .y(this.y)
            .build();
    }
}