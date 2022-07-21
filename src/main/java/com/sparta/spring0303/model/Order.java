package com.sparta.spring0303.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

//    @OneToMany(mappedBy = "order")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")  // 이거 때문에 OrderFood 테이블에 order_id 칼럼이 있음!!!!
    // 근데 뭔가 OrderFood 에서 조인칼럼을 해도될듯한 생각이 든다.
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