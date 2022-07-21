package com.sparta.spring0303.controller;

import com.sparta.spring0303.dto.FoodRequestDto;
import com.sparta.spring0303.model.Food;
import com.sparta.spring0303.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    // 음식 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@RequestBody List<FoodRequestDto> requestDto, @PathVariable Long restaurantId) {
        foodService.registerFood(requestDto, restaurantId);
    }

    // 음식점이 등록한 모든 음식 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFoodList(@PathVariable Long restaurantId) {
        return foodService.getMenu(restaurantId);
    }

}
