package com.example.barungsofthomehwrk.service;

import com.example.barungsofthomehwrk.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getByCustomerId(String id);

    Order addOrder(Order order);

    Order editOrder(Order order);
}
