package com.example.barungsofthomehwrk.validator;

import com.example.barungsofthomehwrk.exception.WrongDate;
import com.example.barungsofthomehwrk.exception.WrongDescription;
import com.example.barungsofthomehwrk.exception.WrongPrice;
import com.example.barungsofthomehwrk.exception.WrongQuantity;
import com.example.barungsofthomehwrk.model.Order;
import com.example.barungsofthomehwrk.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderValidator {

    public static void validate(Order order) throws WrongQuantity, WrongPrice, WrongDescription, WrongDate {
        if (order.getQuantity()==null || order.getQuantity() <= 0)
            throw new WrongQuantity();
        if (order.getPrice() == null || order.getPrice() <= 0)
            throw new WrongPrice();
        if (order.getDescription() == null || "".equals(order.getDescription()))
            throw new WrongDescription();
        if (order.getDate()==null)
            throw new WrongDate();
    }
}
