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
    public Food registerFood(FoodRequestDto requestDto, Long restaurantId) {

        // 음식점 유무 검사
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 음식점입니다"));

        // 같은 음식점 내에서는 음식 이름이 중복될 수 없음 -->  리팩토링 FoodValidator에 들어가야하는걸까?
        validateDuplicatedFood(requestDto, restaurantId);

        // 없으면 음식 등록
        Food Food = new Food(requestDto, restaurant);

        return foodRepository.save(Food);
    }

    // 중복 음식 검사
    private void validateDuplicatedFood(FoodRequestDto requestDto, Long restaurantId) {

        List<Food> foodList = getFoodList(restaurantId);

        for (Food food : foodList) {
            if (food.getFoodName().equals(requestDto.getFoodName())) {
                throw new IllegalArgumentException("이미 등록된 음식입니다");
            }
        }
    }

    // 음식점이 등록한 모든 음식 조회
    public List<Food> getFoodList(Long restaurantId) {
        return foodRepository.findAllByRestaurantId(restaurantId);
    }
}
