package com.sparta.spring0303.service;

import com.sparta.spring0303.dto.FoodRequestDto;
import com.sparta.spring0303.model.Food;
import com.sparta.spring0303.model.Restaurant;
import com.sparta.spring0303.repository.FoodRepository;
import com.sparta.spring0303.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    @Transactional
    public void registerFood(List<FoodRequestDto> requestDtoList, Long restaurantId) {

        // 음식점 유무 검사
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 음식점입니다"));

        for (FoodRequestDto requestDto  : requestDtoList) {
            String name = requestDto.getName();
            int price = requestDto.getPrice();

            // 같은 음식점 내에서는 음식 이름이 중복될 수 없음
            validateDuplicatedFood(name, restaurantId);

            // 없으면 음식 등록
            Food food = new Food(name, price, restaurant);
            foodRepository.save(food);
        }
    }

    // 중복 음식 검사
    private void validateDuplicatedFood(String name, Long restaurantId) {

        List<Food> foodList = getMenu(restaurantId);

        for (Food food : foodList) {
            if (food.getName().equals(name)) {
                throw new IllegalArgumentException("이미 등록된 음식입니다");
            }
        }
    }

    // 음식점이 등록한 모든 음식 조회
    public List<Food> getMenu(Long restaurantId) {
//        return foodRepository.findAllByRestaurantId(restaurantId);

        // 음식점 유무 검사
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 음식점입니다"));

        return foodRepository.findAllByRestaurant(restaurant);
    }
}
