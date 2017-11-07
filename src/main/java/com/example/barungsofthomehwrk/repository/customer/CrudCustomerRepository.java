package com.example.barungsofthomehwrk.repository.customer;

import com.example.barungsofthomehwrk.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudCustomerRepository extends MongoRepository<Customer, String> {
    @Override
    Customer save(Customer customer);

    @Override
    Customer findOne(String id);

    @Override
    boolean exists(String id);

    @Override
    List<Customer> findAll();
}
