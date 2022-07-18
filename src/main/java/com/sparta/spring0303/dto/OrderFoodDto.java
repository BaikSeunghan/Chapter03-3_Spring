package com.sparta.spring0303.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderFoodDto {
    // Request foods
    // 주문 장바구니 역할
    // 음식 주문 정보 받아오기
    private Long foodId;
    private int quantity;


}
