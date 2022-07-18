package com.sparta.spring0303.model;

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
// 주문 장바구니 역할
// 음식 주문정보 클래스
// Response foods
public class OrderFood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String foodName;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;

    public OrderFood(String foodName, int quantity, int price) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }
}