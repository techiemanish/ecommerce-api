package com.ecommerce.product.controller;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.review.model.Review;
import com.ecommerce.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/api/products")
    public ResponseEntity<?> newProduct(@RequestBody Product product){
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String currentTime = sdf.format(date);
        product.setDate(date);
        String productid = currentTime.replaceAll(":", "").replaceAll("-", "").replaceAll(" ","");
        product.setProductId(productid);
        Product save = this.productService.save(product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(save);
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<?> getProductDetails(@PathVariable String id){
        Optional<Product> product= this.productService.findById(id);
        List<Review> reviews = this.reviewService.findByproductId(id);
        product.get().setReviews(reviews);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}
