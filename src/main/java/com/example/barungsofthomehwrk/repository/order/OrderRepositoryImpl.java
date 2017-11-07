package com.example.barungsofthomehwrk.repository.order;

import com.example.barungsofthomehwrk.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final CrudOrderRepository crudOrderRepository;

    @Autowired
    public OrderRepositoryImpl(CrudOrderRepository crudOrderRepository) {
        this.crudOrderRepository = crudOrderRepository;
    }

    @Override
    public List<Order> getByCustomerId(String id) {
        return crudOrderRepository.findByCustomer(id);
    }

    @Override
    public Order save(Order order) {
        return crudOrderRepository.save(order);
    }

    @Override
    public boolean isOrder(String id) {
        return crudOrderRepository.exists(id);
    }
}
