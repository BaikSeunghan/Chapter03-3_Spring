package com.sparta.spring0303.service;

import com.sparta.spring0303.dto.OrderFoodDto;
import com.sparta.spring0303.dto.OrderRequestDto;
import com.sparta.spring0303.model.Food;
import com.sparta.spring0303.model.Order;
import com.sparta.spring0303.model.OrderFood;
import com.sparta.spring0303.model.Restaurant;
import com.sparta.spring0303.repository.FoodRepository;
import com.sparta.spring0303.repository.OrderRepository;
import com.sparta.spring0303.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;

    @Transactional
    public Order createOrder(OrderRequestDto requestDto) {
        return getOrder(requestDto);
    }

    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

    private Order getOrder(OrderRequestDto requestDto) {

        Long restaurantId = requestDto.getRestaurantId();
        // 이걸로 Restaurant 찾고 name / 배달비 얻어온다.
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 음식점입니다"));

        // 주문 음식점
        String restaurantName = restaurant.getName();
        // 음식점 배달비
        int deliveryFee = restaurant.getDeliveryFee();
        // 주문한 음식 리스트
        List<OrderFood> orderFoods = new ArrayList<>();
        // 총액 선언
        int totalPrice = 0;

        List<OrderFoodDto> orderFoodDtoList = requestDto.getFoods();
        for (OrderFoodDto orderFoodDto : orderFoodDtoList) {
            // 이걸로 Food 객체 찾아와서 가격 가져온다음 갯수랑 곱해서 총 가격을 정한다.
            Long foodId = orderFoodDto.getId();
            Food food = foodRepository.findById(foodId)
                    .orElseThrow(() -> new NullPointerException("존재하지 않는 음식입니다"));

            // 음식 이름
            String foodName = food.getName();
            // 주문 개수
            int quantity = orderFoodDto.getQuantity();
            if (quantity < 1 || quantity > 100) {
                throw new IllegalArgumentException("1개 이상 주문해주세요");
            }
            // 음식 가격
            int price = food.getPrice() * quantity;
            totalPrice += price;
            if (totalPrice < restaurant.getMinOrderPrice()) {
                throw new IllegalArgumentException("최소 주문 가격 이하입니다.");
            }
            // OrderFood 만들기
            OrderFood orderFood = new OrderFood(foodName, quantity, price);

            orderFoods.add(orderFood);
        }
        totalPrice += deliveryFee;
        Order order = new Order(restaurantName, orderFoods, deliveryFee, totalPrice);
        return orderRepository.save(order);
    }
}
