package com.example.barungsofthomehwrk.validator;

import com.example.barungsofthomehwrk.model.Order;
import com.example.barungsofthomehwrk.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderValidator {

    private final CustomerService customerService;

    @Autowired
    public OrderValidator(CustomerService customerService) {
        this.customerService = customerService;
    }

    public boolean validate(Order order) {
        return customerService.isCustomer(order.getCustomerId()) && order.getQuantity() > 0 && order.getPrice() > 0 &&
                order.getDescription() != null && !"".equals(order.getDescription()) && order.getDate()!=null;
    }
}
