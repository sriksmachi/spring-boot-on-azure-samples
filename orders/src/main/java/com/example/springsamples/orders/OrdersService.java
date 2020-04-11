package com.example.springsamples.orders;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrdersService {
    Optional<List<OrderModel>> findByUserId(long user_id);
    String createOrder(OrderModel order);
}
