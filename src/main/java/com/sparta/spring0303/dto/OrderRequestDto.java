package com.sparta.spring0303.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderRequestDto {

    // request
    private Long restaurantId;
    private List<OrderFoodDto> foods;
}
