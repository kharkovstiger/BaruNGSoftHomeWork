package com.example.barungsofthomehwrk.service;

import com.example.barungsofthomehwrk.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer addCustomer(Customer customer);

    Customer editCustomer(Customer customer);

    boolean isCustomer(Long customerId);
}
