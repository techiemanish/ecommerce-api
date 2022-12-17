package com.ecommerce.signup.service;

import com.ecommerce.signup.model.Signup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface signupService extends MongoRepository<Signup, String>{
    public Signup findByEmail(String email);
}
