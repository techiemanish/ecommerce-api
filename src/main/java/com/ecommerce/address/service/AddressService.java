package com.ecommerce.address.service;

import com.ecommerce.address.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService extends MongoRepository<Address, String> {
    public List<Address> findByemail(String email);
    public void deleteByEmail(String email);
}
