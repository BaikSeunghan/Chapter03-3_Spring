package com.sparta.spring0303.validator;

import com.sparta.spring0303.dto.RestaurantRequestDto;
import org.springframework.stereotype.Component;

@Component
public class RestaurantValidator {

    public static void validateRestaurantInput(RestaurantRequestDto requestDto) {
        if (requestDto.getMinOrderPrice() < 1000 || requestDto.getMinOrderPrice() > 100000) {
            throw new IllegalArgumentException("1,000원 ~ 100,000원 사이로 입력해주세요.");
        }
        if (requestDto.getMinOrderPrice() % 100 != 0) {
            throw new IllegalArgumentException("100 원 단위로만 입력 가능합니다.");
        }

        if (requestDto.getDeliveryFee() < 0 || requestDto.getMinOrderPrice() > 10000) {
            throw new IllegalArgumentException("0원 ~ 10,000원 사이로 입력해주세요.");
        }
        if (requestDto.getDeliveryFee() % 500 != 0) {
            throw new IllegalArgumentException("500 원 단위로만 입력 가능합니다.");
        }
    }
}
