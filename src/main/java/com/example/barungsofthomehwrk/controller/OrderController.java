package com.example.barungsofthomehwrk.controller;

import com.example.barungsofthomehwrk.exception.WrongDate;
import com.example.barungsofthomehwrk.exception.WrongDescription;
import com.example.barungsofthomehwrk.exception.WrongPrice;
import com.example.barungsofthomehwrk.exception.WrongQuantity;
import com.example.barungsofthomehwrk.model.Order;
import com.example.barungsofthomehwrk.service.OrderService;
import com.example.barungsofthomehwrk.validator.OrderValidator;
import com.google.gson.Gson;
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
    private final Gson gson=new Gson();

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
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
    public ResponseEntity<String> addOrder(@RequestBody Order order){
        System.err.println(order);
        try {
            OrderValidator.validate(order);
        } catch (WrongQuantity wrongQuantity) {
            return new ResponseEntity<>(gson.toJson("Wrong quantity"), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (WrongPrice wrongPrice) {
            return new ResponseEntity<>(gson.toJson("Wrong price"), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (WrongDescription wrongDescription) {
            return new ResponseEntity<>(gson.toJson("Wrong description"), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (WrongDate wrongDate) {
            return new ResponseEntity<>(gson.toJson("Wrong date"), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(gson.toJson(orderService.addOrder(order)),HttpStatus.OK);
    }
}
