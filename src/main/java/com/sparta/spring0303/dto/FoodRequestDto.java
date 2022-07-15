package com.sparta.spring0303.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class FoodRequestDto {

    private String foodName;
    private int price;
}
