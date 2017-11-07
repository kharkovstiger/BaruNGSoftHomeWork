package com.example.barungsofthomehwrk.repository.order;


import com.example.barungsofthomehwrk.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CrudOrderRepository extends MongoRepository<Order, String> {
    @Override
    Order save(Order order);

    @Override
    boolean exists(String id);

    @Query(value = "{'customerId' : ?0}")
    List<Order> findByCustomer(String id);
}
