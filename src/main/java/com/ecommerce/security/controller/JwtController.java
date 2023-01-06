package com.ecommerce.security.controller;

import com.ecommerce.security.helper.JwtUtil;
import com.ecommerce.security.model.JwtRespone;
import com.ecommerce.security.model.UserRequest;
import com.ecommerce.security.service.CustomUserDetailService;
import com.ecommerce.security.service.JwtUserService;
import com.ecommerce.utils.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private JwtUserService jwtUserService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody UserRequest userRequest){
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUserName(),userRequest.getPassword()));
        }catch (Exception e){
            e.printStackTrace();
            Error error = new Error();
            error.setStatus("Unauthorized");
            error.setMessage("Bad Credentials entered.");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }
        UserDetails userDetails = this.customUserDetailService.loadUserByUsername(userRequest.getUserName());
        String token = this.jwtUtil.generateToken(userDetails);
        JwtRespone jwtRespone = new JwtRespone();
        jwtRespone.setToken(token);
        jwtRespone.setType("Bearer");
        jwtRespone.setExpires_in("3600");
        return ResponseEntity.status(HttpStatus.OK).body(jwtRespone);
    }
}
