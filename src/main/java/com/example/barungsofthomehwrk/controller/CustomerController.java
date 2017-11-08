package com.example.barungsofthomehwrk.controller;

import com.example.barungsofthomehwrk.exception.WrongAge;
import com.example.barungsofthomehwrk.exception.WrongEmail;
import com.example.barungsofthomehwrk.exception.WrongFirstName;
import com.example.barungsofthomehwrk.exception.WrongLastName;
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
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer){
        try {
            CustomerValidator.validate(customer);
        } catch (WrongEmail wrongEmail) {
            return new ResponseEntity<>("Wrong Email", HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (WrongAge wrongAge) {
            return new ResponseEntity<>("Wrong age", HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (WrongFirstName wrongFirstName) {
            return new ResponseEntity<>("Wrong first name", HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (WrongLastName wrongLastName) {
            return new ResponseEntity<>("Wrong last name", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.OK);
    }
}
