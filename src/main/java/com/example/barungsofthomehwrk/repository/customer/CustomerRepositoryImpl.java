package com.example.barungsofthomehwrk.repository.customer;

import com.example.barungsofthomehwrk.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CrudCustomerRepository crudCustomerRepository;

    @Autowired
    public CustomerRepositoryImpl(CrudCustomerRepository crudCustomerRepository) {
        this.crudCustomerRepository = crudCustomerRepository;
    }

    @Override
    public boolean isCustomer(String customerId) {
        return crudCustomerRepository.exists(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return crudCustomerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return crudCustomerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(String id) {
        return crudCustomerRepository.findOne(id);
    }
}
