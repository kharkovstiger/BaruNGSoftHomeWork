package com.example.barungsofthomehwrk.service;

import com.example.barungsofthomehwrk.model.Customer;
import com.example.barungsofthomehwrk.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements com.example.barungsofthomehwrk.service.CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer editCustomer(Customer customer) {
        return !customerRepository.isCustomer(customer.getId())?null:customerRepository.save(customer);
    }

    @Override
    public boolean isCustomer(String customerId) {
        return customerRepository.isCustomer(customerId);
    }
}
