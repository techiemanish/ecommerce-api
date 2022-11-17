package com.ecommerce.order.service;

import com.ecommerce.order.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface orderService extends MongoRepository<Order, String> {
    public List<Order> findByEmail(String email);
}
