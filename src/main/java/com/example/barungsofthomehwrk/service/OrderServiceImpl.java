package com.example.barungsofthomehwrk.service;

import com.example.barungsofthomehwrk.model.Order;
import com.example.barungsofthomehwrk.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getByCustomerId(String id) {
        return orderRepository.getByCustomerId(id);
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getByOrderId(String id) {
        return orderRepository.getByOrderId(id);
    }
}
