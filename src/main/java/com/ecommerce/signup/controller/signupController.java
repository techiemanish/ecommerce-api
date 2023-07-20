package com.ecommerce.signup.controller;

import com.ecommerce.signup.model.Signup;
import com.ecommerce.utils.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.signup.service.signupService;

@RestController
@CrossOrigin(origins = {"https://mycscode.com/","https://ecommerce.mycscode.com/","http://localhost:3000", "https://trueclix.netlify.app/"})public class signupController {
    @Autowired
    private signupService signupService;

    @PostMapping("/api/signup")
    public ResponseEntity<?> signup(@RequestBody Signup signup){
        String email = signup.getEmail();
        Signup data = this.signupService.findByEmail(email);
        if(data != null){
            Error error = new Error();
            error.setStatus("User Already Exist!");
            error.setMessage("An existing user was found with the provided credentials. Please log in or use different registration information.");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }
        else{
            Signup save = this.signupService.save(signup);
            return ResponseEntity.ok(save);
        }
    }
}
