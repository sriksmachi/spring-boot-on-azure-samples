package com.example.springsamples.orders;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    private OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Optional<List<OrderModel>> findByUserId(long user_id) {
        return ordersRepository.findByUserId(user_id);
    }
}
