package com.ecommerce.order.controller;

import com.ecommerce.address.model.Address;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private orderService orderService;

    @PostMapping("/api/order")
    public ResponseEntity<?> saveOrder(@RequestBody Order order) {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String currentTime = sdf.format(date);
        String orderId = currentTime.replaceAll(":", "").replaceAll("-", "").replaceAll(" ","");
        order.setOrderid(orderId);
        Address address = order.getAddress();
        address.setAddressId(orderId);
        order.setDate(date);
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
