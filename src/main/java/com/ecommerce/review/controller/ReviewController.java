package com.ecommerce.review.controller;

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

@RestController
@CrossOrigin(origins = {"https://mycscode.com/","https://ecommerce.mycscode.com/","http://localhost:3000", "https://trueclix.netlify.app/"})
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/api/reviews")
    public ResponseEntity<?> postReview(@RequestBody Review review){
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String currentTime = sdf.format(date);
        String id = currentTime.replaceAll(":", "").replaceAll("-", "").replaceAll(" ","");
        review.setDate(date);
        review.setReviewId(id);
        Review saveReview = this.reviewService.save(review);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(saveReview);
    }

    @GetMapping("/api/reviews/{userEmail}")
    public ResponseEntity<List<Review>> reviewByEmail(@PathVariable String userEmail){
        List<Review> reviews = this.reviewService.findByuserEmail(userEmail);
        return ResponseEntity.status(HttpStatus.OK).body(reviews);
    }

    @PutMapping("/api/reviews/")
    public ResponseEntity<Review> updateReview(@RequestBody Review review){
        this.reviewService.save(review);
        return ResponseEntity.status(HttpStatus.OK).body(review);
    }

    @DeleteMapping("/api/reviews/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable String id){
        this.reviewService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Review has been deleted Successfully!");
    }
}
