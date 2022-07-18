package com.sparta.spring0303.validator;

import com.sparta.spring0303.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class FoodValidator {
    public static void validateFoodInput(int price) {

        if (price < 100 || price > 1000000) {
            throw new IllegalArgumentException("가격은 1,000원 ~ 1,000,000원 사이로 입력해주세요.");
        }
        if (price % 100 != 0) {
            throw new IllegalArgumentException("100 원 단위로만 입력 가능합니다.");
        }
    }
}
