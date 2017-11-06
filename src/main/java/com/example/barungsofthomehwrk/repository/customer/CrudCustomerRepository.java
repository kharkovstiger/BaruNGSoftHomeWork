package com.example.barungsofthomehwrk.repository.customer;

import com.example.barungsofthomehwrk.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudCustomerRepository extends CrudRepository<Customer, Long> {
    @Override
    Customer save(Customer customer);

    @Override
    Customer findOne(Long id);

    @Override
    boolean exists(Long id);

    @Override
    List<Customer> findAll();
}
