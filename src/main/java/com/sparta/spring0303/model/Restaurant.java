package com.sparta.spring0303.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.spring0303.dto.RestaurantRequestDto;
import com.sparta.spring0303.validator.RestaurantValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor
@AllArgsConstructor
@Entity // DB 테이블 역할을 합니다.
public class Restaurant {

    @Id
    @GeneratedValue // 각 DB에 맞는 걸 자동으로 맞춰서 증가
    @Column(name = "restaurant_id")
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int minOrderPrice;
    @Column(nullable = false)
    private int deliveryFee;

//    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Food> foods = new ArrayList<>();
    // 주석처리하긴했는데,, 설마 레스토랑 메뉴를 가져올때 getFoods로 하면되는걸까?
    // 지금은 Food에서 restaurantId받고 Restaurant찾아서 하고있음.


    // 음식점 등록 시 이용합니다.
    public Restaurant(RestaurantRequestDto requestDto) {

        // 입력값 Validation
        RestaurantValidator.validateRestaurantInput(requestDto);

        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();

    }
}
