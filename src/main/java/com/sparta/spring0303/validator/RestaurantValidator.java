package com.sparta.spring0303.validator;

import com.sparta.spring0303.dto.RestaurantRequestDto;
import com.sparta.spring0303.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RestaurantValidator {

    public static void validateRestaurantInput(RestaurantRequestDto requestDto) {

//        Optional<Restaurant> found = restaurantRepository.findByName(requestDto.getName());
//        if (found.isPresent()) {
//            throw new IllegalArgumentException("이미 등록됨 음식점입니다.");
//        }

        if (requestDto.getMinOrderPrice() < 1000 || requestDto.getMinOrderPrice() > 100000) {
            throw new IllegalArgumentException("최소 주문 금액은 1,000원 ~ 100,000원 사이로 입력해주세요.");
        }
        if (requestDto.getMinOrderPrice() % 100 != 0) {
            throw new IllegalArgumentException("100 원 단위로만 입력 가능합니다.");
        }
        if (requestDto.getDeliveryFee() < 0 || requestDto.getDeliveryFee() > 10000) {
            throw new IllegalArgumentException("배달비는 0원 ~ 10,000원 사이로 입력해주세요.");
        }
        if (requestDto.getDeliveryFee() % 500 != 0) {
            throw new IllegalArgumentException("500 원 단위로만 입력 가능합니다.");
        }
    }
}
