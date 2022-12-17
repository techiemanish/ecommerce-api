package com.ecommerce.address.controller;

import com.ecommerce.address.model.Address;
import com.ecommerce.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/api/address")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address){
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String currentTime = sdf.format(date);
        String addressId = currentTime.replaceAll(":", "").replaceAll("-", "").replaceAll(" ","");
        address.setAddressId(addressId);
        Address result = this.addressService.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/api/address/{email}")
    public ResponseEntity<List<Address>> addressByEmail(@PathVariable String email){
        List<Address> result = this.addressService.findByemail(email);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
