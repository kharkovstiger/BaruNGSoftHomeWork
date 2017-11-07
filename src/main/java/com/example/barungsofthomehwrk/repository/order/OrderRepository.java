package com.example.barungsofthomehwrk.repository.order;

import com.example.barungsofthomehwrk.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getByCustomerId(String id);

    Order save(Order order);

    boolean isOrder(String id);
}
