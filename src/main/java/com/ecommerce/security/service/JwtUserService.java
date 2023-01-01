package com.ecommerce.security.service;

import com.ecommerce.security.model.UserRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JwtUserService extends MongoRepository<UserRequest, String> {
    public UserRequest findByuserName(String userName);
}
