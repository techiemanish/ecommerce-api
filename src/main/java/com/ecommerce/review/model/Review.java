package com.ecommerce.review.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Review")
public class Review {
    @Id
    private String reviewId;
    private String productId;
    private String userEmail;
    private String comment;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date date;

    public Review() {
    }

    public Review(String reviewId, String productId, String userEmail, String comment, Date date) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.userEmail = userEmail;
        this.comment = comment;
        this.date = date;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", productId='" + productId + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
