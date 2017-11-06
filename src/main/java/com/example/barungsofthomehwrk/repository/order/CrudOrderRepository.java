package com.example.barungsofthomehwrk.repository.order;


import com.example.barungsofthomehwrk.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudOrderRepository extends CrudRepository<Order, Long>{
    @Override
    Order save(Order order);

    @Override
    boolean exists(Long aLong);

    @Query(value = "{'customerId' : ?0}")
    List<Order> findByCustomer(Long id);
}
