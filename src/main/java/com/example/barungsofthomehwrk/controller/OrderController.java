package com.example.barungsofthomehwrk.controller;

import com.example.barungsofthomehwrk.model.Order;
import com.example.barungsofthomehwrk.service.OrderService;
import com.example.barungsofthomehwrk.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = OrderController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    static final String REST_URL = "/api/order";
    private final OrderService orderService;
    private final OrderValidator orderValidator;

    @Autowired
    public OrderController(OrderService orderService, OrderValidator orderValidator) {
        this.orderService = orderService;
        this.orderValidator = orderValidator;
    }

    @GetMapping(value = "/getByCustomerId")
    public List<Order> getByCustomerId(@PathParam("id") String id){
        return orderService.getByCustomerId(id);
    }

    @PostMapping(value = "/addOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        if (!orderValidator.validate(order))
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<>(orderService.addOrder(order),HttpStatus.OK);
    }

    @PostMapping(value = "/editOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> editOrder(@RequestBody Order order){
        if (!orderValidator.validate(order))
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        Order editedOrder=orderService.editOrder(order);
        return editedOrder!=null?new ResponseEntity<>(editedOrder,HttpStatus.OK):new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
