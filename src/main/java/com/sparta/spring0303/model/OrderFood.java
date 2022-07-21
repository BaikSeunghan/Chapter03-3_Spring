package com.sparta.spring0303.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@AllArgsConstructor
@Entity // DB 테이블 역할을 합니다.
// 주문 장바구니 역할
// 음식 주문정보 클래스
// Response foods
public class OrderFood {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

//    @ManyToOne()
//    private Order order;  // order필드를 안해줘도 테이블에 order_id 칼럼이 있다.

    public OrderFood(String foodName, int quantity, int price) {
        this.name = foodName;
        this.quantity = quantity;
        this.price = price;
    }
}