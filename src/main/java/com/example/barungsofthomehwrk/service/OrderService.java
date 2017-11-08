package com.example.barungsofthomehwrk.service;

import com.example.barungsofthomehwrk.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> getByCustomerId(String id);

    Order addOrder(Order order);

    Order getByOrderId(String id);
}
