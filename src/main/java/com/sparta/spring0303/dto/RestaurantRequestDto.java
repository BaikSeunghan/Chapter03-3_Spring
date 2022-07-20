package com.sparta.spring0303.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class RestaurantRequestDto {

    @NotBlank(message = "음식점 이름을 입력해주세요")
    private String name;

    @NotBlank(message = "최소 주문가격을 입력해주세요")
    private int minOrderPrice;

    @NotBlank(message = "기본 배달비를 입력해주세요")
    private int deliveryFee;
}
