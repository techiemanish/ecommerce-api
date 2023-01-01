package com.ecommerce.security.service;

import com.ecommerce.security.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private JwtUserService jwtUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRequest userRequest = this.jwtUserService.findByuserName(username);
        if(null != userRequest && userRequest.getUserName().equals("apiUser")){
            return new User(userRequest.getUserName(), userRequest.getPassword() , new ArrayList<>());
        }
        return null;
    }
}
