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

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @Transactional
    public Restaurant registerRestaurant(RestaurantRequestDto requestDto) {
        Optional<Restaurant> found = restaurantRepository.findByName(requestDto.getName());
        if (found.isPresent()) {
            throw new IllegalArgumentException("이미 등록됨 음식점입니다.");
        }

        Restaurant restaurant = new Restaurant(requestDto);
        return restaurantRepository.save(restaurant);
    }
}
