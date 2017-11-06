package com.example.barungsofthomehwrk.repository.order;

import com.example.barungsofthomehwrk.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

    private final CrudOrderRepository crudOrderRepository;

    @Autowired
    public OrderRepositoryImpl(CrudOrderRepository crudOrderRepository) {
        this.crudOrderRepository = crudOrderRepository;
    }

    @Override
    public List<Order> getByCustomerId(Long id) {
        return crudOrderRepository.findByCustomer(id);
    }

    @Override
    public Order save(Order order) {
        return crudOrderRepository.save(order);
    }

    @Override
    public boolean isOrder(Long id) {
        return crudOrderRepository.exists(id);
    }
}
