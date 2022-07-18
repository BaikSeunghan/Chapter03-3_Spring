package com.sparta.spring0303.repository;

import com.sparta.spring0303.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
