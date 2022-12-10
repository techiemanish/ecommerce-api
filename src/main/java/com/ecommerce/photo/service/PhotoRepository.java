package com.ecommerce.photo.service;

import com.ecommerce.photo.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface PhotoRepository extends MongoRepository<Photo, String> {
}
