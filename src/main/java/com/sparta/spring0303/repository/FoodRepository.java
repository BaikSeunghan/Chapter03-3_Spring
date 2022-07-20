package com.sparta.spring0303.repository;

import com.sparta.spring0303.model.Food;
import com.sparta.spring0303.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    //    List<Food> findAllByRestaurantId(Long restaurantId);
    List<Food> findAllByRestaurant(Restaurant restaurant);
}
