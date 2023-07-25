package com.ecommerce.login.controller;

import com.ecommerce.address.service.AddressService;
import com.ecommerce.login.model.DeleteRequest;
import com.ecommerce.login.model.DeleteResponse;
import com.ecommerce.login.model.LoginRequest;
import com.ecommerce.login.model.LoginResponse;
import com.ecommerce.order.service.orderService;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.review.service.ReviewService;
import com.ecommerce.security.helper.JwtUtil;
import com.ecommerce.security.model.JwtRespone;
import com.ecommerce.security.service.CustomUserDetailService;
import com.ecommerce.signup.model.Signup;
import com.ecommerce.signup.service.signupService;
import com.ecommerce.utils.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"https://mycscode.com/","https://ecommerce.mycscode.com/","http://localhost:3000", "https://trueclix.netlify.app/"})
public class loginController {

    @Autowired
    private signupService signupService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private orderService orderService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = new LoginResponse();
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Signup result = this.signupService.findByEmail(email);
        try{
            if(null != result && email.equalsIgnoreCase(result.getEmail()) && password.equals(result.getPassword())){
                loginResponse.setFirstname(result.getFirstname());
                loginResponse.setLastname(result.getLastname());
                loginResponse.setEmail(result.getEmail());
                loginResponse.setPhone(result.getPhone());
                loginResponse.setSeller(result.getIsSeller());
                loginResponse.setAddress(this.addressService.findByemail(result.getEmail()));
                loginResponse.setOrders(this.orderService.findByEmail(result.getEmail()));
                loginResponse.setReviews(this.reviewService.findByuserEmail(result.getEmail()));
                if(result.getIsSeller()){
                    loginResponse.setProducts(this.productService.findBysellerEmail(result.getEmail()));
                }else{
                    loginResponse.setProducts(null);
                }

                UserDetails userDetails = this.customUserDetailService.loadUserByUsername("apiUser");
                String token = this.jwtUtil.generateToken(userDetails);
                JwtRespone jwtRespone = new JwtRespone();
                jwtRespone.setToken(token);
                jwtRespone.setType("Bearer");
                jwtRespone.setExpires_in("3600");
                loginResponse.setJwtToken(jwtRespone);
            }
            else {
                if(result == null){
                    Error error = new Error();
                    error.setStatus("No Account exist with this mail");
                    error.setMessage("Please register yourself!");
                    return ResponseEntity.status(HttpStatus.OK).body(error);
                }
                Error error = new Error();
                error.setStatus("Unauthorized");
                error.setMessage("Wrong credentials. Please enter correct details.");
                return ResponseEntity.status(HttpStatus.OK).body(error);
            }
        }
        catch (Exception e){
            Error error = new Error();
            error.setStatus("Internal Server Error");
            error.setMessage(String.valueOf(e));

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }

    @DeleteMapping("api/login")
    public ResponseEntity<?> deleteMyAccount(@RequestBody DeleteRequest deleteRequest){
        String email = deleteRequest.getEmail();
        Signup result = this.signupService.findByEmail(email);
        if(result != null){
            if(result.getIsSeller()){
                this.productService.deleteById(email);
            }
            this.signupService.deleteById(email);
            this.addressService.deleteByEmail(email);
            this.orderService.deleteByEmail(email);
            this.reviewService.deleteByuserEmail(email);
            DeleteResponse deleteResponse = new DeleteResponse();
            deleteResponse.setStatus("Success");
            deleteResponse.setMessage("Account Successfully Deleted!");
            return ResponseEntity.status(HttpStatus.OK).body(deleteResponse);
        }else{
            DeleteResponse deleteResponse = new DeleteResponse();
            deleteResponse.setStatus("Not Found");
            deleteResponse.setMessage("Account does not exist!");
            return ResponseEntity.status(HttpStatus.OK).body(deleteResponse);
        }
    }
}
