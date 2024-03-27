package com.ecommerce;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://mycscode.com/","https://ecommerce.mycscode.com/","http://localhost:3000", "https://trueclix.netlify.app/"})
public class RootController {
    @GetMapping("/")
    public ResponseEntity<?> rootController(){
        return ResponseEntity.status(HttpStatus.OK).body("Ecommerce Application is up and running on v2.6");
    }
}
