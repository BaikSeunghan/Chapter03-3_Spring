package com.sparta.spring0303.service;

import com.sparta.spring0303.dto.RestaurantRequestDto;
import com.sparta.spring0303.model.Restaurant;
import com.sparta.spring0303.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant registerRestaurant(RestaurantRequestDto requestDto) {
        Restaurant restaurant = new Restaurant(requestDto);
        return restaurantRepository.save(restaurant);
    }
}
