package com.sparta.spring0303.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderFoodDto {
    // Request foods
    // 주문 장바구니 역할
    // 음식 주문 정보 받아오기
    private Long id;
    private int quantity;


}
