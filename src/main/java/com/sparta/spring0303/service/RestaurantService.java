package com.sparta.spring0303.service;

import com.sparta.spring0303.dto.RestaurantRequestDto;
import com.sparta.spring0303.model.Restaurant;
import com.sparta.spring0303.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Restaurant registerRestaurant(RestaurantRequestDto requestDto) {

        Restaurant restaurant = new Restaurant(requestDto);
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }
}
