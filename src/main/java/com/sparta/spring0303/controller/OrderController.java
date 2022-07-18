package com.sparta.spring0303.controller;

import com.sparta.spring0303.dto.OrderRequestDto;
import com.sparta.spring0303.model.Order;
import com.sparta.spring0303.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 주문 요청
    @PostMapping("/order/request")
    public Order registerOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.createOrder(requestDto);
    }

    // 주문 조회
    @GetMapping("/orders")
    public List<Order> getOrderList() {
        return orderService.getOrderList();
    }

}
