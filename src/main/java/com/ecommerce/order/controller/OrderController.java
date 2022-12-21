package com.ecommerce.order.controller;

import com.ecommerce.address.model.Address;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.orderService;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.utils.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://trueclix.netlify.app/"})
public class OrderController {
    @Autowired
    private orderService orderService;
    @Autowired
    private ProductService productService;

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
        String productId = String.valueOf(order.getProductid());
        Optional<Product> product = this.productService.findById(productId);
        int updatedStock = product.get().getStock() - order.getQuantity();
        if(updatedStock < 0){
            Error error = new Error();
            error.setStatus("Out of Stock");
            error.setMessage("Sorry. We cannot process your order. Item in stock is "+ product.get().getStock()+ ". You ordered " +  order.getQuantity());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
        product.get().setStock(updatedStock);
        this.productService.save(product.get());
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
