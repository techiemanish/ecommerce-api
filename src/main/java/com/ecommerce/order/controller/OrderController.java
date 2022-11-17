package com.ecommerce.order.controller;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private orderService orderService;

    @PostMapping("/api/order")
    public ResponseEntity<?> saveOrder(@RequestBody Order order){
        Order save = this.orderService.save(order);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(save);
    }

    @GetMapping("/api/order/{email}")
    public ResponseEntity<List<Order>> getAllOrdersByEmail(@PathVariable String email){
        List<Order> result= this.orderService.findByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/api/order")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> result= this.orderService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
