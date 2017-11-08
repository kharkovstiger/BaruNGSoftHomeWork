package com.example.barungsofthomehwrk.controller;

import com.example.barungsofthomehwrk.exception.WrongDate;
import com.example.barungsofthomehwrk.exception.WrongDescription;
import com.example.barungsofthomehwrk.exception.WrongPrice;
import com.example.barungsofthomehwrk.exception.WrongQuantity;
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
@CrossOrigin
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

    @GetMapping(value = "/{id}")
    public Order getByOrderId(@PathVariable("id") String id){
        return orderService.getByOrderId(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addOrder(@RequestBody Order order){
        try {
            orderValidator.validate(order);
        } catch (WrongQuantity wrongQuantity) {
            return new ResponseEntity<>("Wrong quantity", HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (WrongPrice wrongPrice) {
            return new ResponseEntity<>("Wrong price", HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (WrongDescription wrongDescription) {
            return new ResponseEntity<>("Wrong description", HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (WrongDate wrongDate) {
            return new ResponseEntity<>("Wrong date", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(orderService.addOrder(order),HttpStatus.OK);
    }
}
