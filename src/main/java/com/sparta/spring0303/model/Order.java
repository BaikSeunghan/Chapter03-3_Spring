package com.sparta.spring0303.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@AllArgsConstructor
@Entity(name = "orders") // DB 테이블 역할을 합니다.
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderFood> foods = new ArrayList<>();

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;


    public Order(String restaurantName, List<OrderFood> orderFoods, int deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.foods = orderFoods;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}