package com.sparta.spring0303.repository;

import com.sparta.spring0303.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByName(String name);
//    List<Food> findAllByRestaurantIdAndFoodList_FoodName(Long userId, String foodName);

}
