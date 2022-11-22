package com.ecommerce.review.service;

import com.ecommerce.review.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService extends MongoRepository<Review, String> {
    public List<Review> findByuserEmail(String userEmail);
    public List<Review> findByproductId(String productId);
}
