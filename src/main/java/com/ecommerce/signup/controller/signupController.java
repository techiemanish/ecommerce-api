package com.ecommerce.signup.controller;

import com.ecommerce.signup.model.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.signup.service.signupService;

@RestController
public class signupController {
    @Autowired
    private signupService signupService;

    @PostMapping("/api/signup")
    public ResponseEntity<?> signup(@RequestBody Signup signup){
        Signup save = this.signupService.save(signup);
        return ResponseEntity.ok(save);
    }
}
