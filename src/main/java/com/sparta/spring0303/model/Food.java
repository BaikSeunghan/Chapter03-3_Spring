package com.sparta.spring0303.model;

import com.sparta.spring0303.dto.FoodRequestDto;
import com.sparta.spring0303.validator.FoodValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@AllArgsConstructor
@Entity // DB 테이블 역할을 합니다.
public class Food {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;  // Has-a 관계

    // 음식점 등록 시 이용합니다.
    public Food(String name, int price, Restaurant restaurant) {

        // 가격 설정값 Validation
        FoodValidator.validateFoodInput(price);

        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }


}
