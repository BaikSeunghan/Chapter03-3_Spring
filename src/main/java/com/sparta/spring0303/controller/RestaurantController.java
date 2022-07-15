package com.sparta.spring0303.controller;

import com.sparta.spring0303.dto.RestaurantRequestDto;
import com.sparta.spring0303.model.Restaurant;
import com.sparta.spring0303.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurantList() {
        return restaurantService.getRestaurants();
    }
    @PostMapping("/restaurants/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantRequestDto requestDto) {
        return restaurantService.registerRestaurant(requestDto);
    }
}
