package com.ecommerce.product.controller;

import com.ecommerce.photo.model.Photo;
import com.ecommerce.photo.service.PhotoService;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.review.model.Review;
import com.ecommerce.review.service.ReviewService;
import com.ecommerce.utils.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private PhotoService photoService;

    @PostMapping("/api/products")
    public ResponseEntity<?> newProduct(@RequestBody Product product) throws IOException {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String currentTime = sdf.format(date);
        product.setDate(date);
        String productid = currentTime.replaceAll(":", "").replaceAll("-", "").replaceAll(" ","");
        String data = this.photoService.addPhoto((String) productid, (MultipartFile) product.getImage());
        product.setImageId(productid);
        product.setProductId(productid);
        Product save = this.productService.save(product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(save);
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<?> getProductDetails(@PathVariable String id){
        Optional<Product> product= this.productService.findById(id);
        if(product.isEmpty()){
            Error error = new Error();
            error.setStatus("404");
            error.setMessage("No product found. Please refine your search.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        //Finding all the review associated with the product id
        List<Review> reviews = this.reviewService.findByproductId(id);
        product.get().setReviews(reviews);
        //Finding the photo for the product using product id
        Photo photo = this.photoService.getPhoto(id);
        String image = Base64.getEncoder().encodeToString(photo.getImage().getData());
        product.get().setPhotoData(image);
        product.get().setImageId(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>>  getAllProduts(){
        List<Product> result = this.productService.findAll();
        //Need to write logic, each product should have review and image
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
