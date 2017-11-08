package com.example.barungsofthomehwrk.controller;

import com.example.barungsofthomehwrk.model.Customer;
import com.example.barungsofthomehwrk.service.CustomerService;
import com.example.barungsofthomehwrk.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = CustomerController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class CustomerController {

    static final String REST_URL = "/api/customer";
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomerById(@PathVariable("id") String id){
        return customerService.getCustomerById(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        if (!CustomerValidator.validate(customer))
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.OK);
    }

    @PostMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer){
        if (!CustomerValidator.validate(customer))
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        Customer editedCustomer=customerService.editCustomer(customer);
        return editedCustomer==null?new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED):new ResponseEntity<>(editedCustomer,HttpStatus.OK);
    }
}
