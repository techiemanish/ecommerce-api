package com.ecommerce.product.service;

import com.ecommerce.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductService extends MongoRepository<Product, String> {
}
