package com.example.barungsofthomehwrk.repository.customer;

import com.example.barungsofthomehwrk.model.Customer;

import java.util.List;

public interface CustomerRepository {
    boolean isCustomer(Long customerId);

    List<Customer> getAllCustomers();

    Customer save(Customer customer);
}
