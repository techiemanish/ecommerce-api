package com.ecommerce.product.model;

import com.ecommerce.review.model.Review;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Product")
public class Product {
    @Id
    private String productId;
    private String productName;
    private String description;
    private int stock;
    private int price;
    private List<String> pinCode;
    private String category;
    private String sellerName;
    private String sellerEmail;
    private List<Review> reviews;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date date;
    private String imageId;
    private Binary image;
    private String photoData;

    public Product() {
    }

    public Product(String productId, String productName, String description, int stock, int price, List<String> pinCode, String category, String sellerName, String sellerEmail, List<Review> reviews, Date date, String imageId, Binary image, String photoData) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.pinCode = pinCode;
        this.category = category;
        this.sellerName = sellerName;
        this.sellerEmail = sellerEmail;
        this.reviews = reviews;
        this.date = date;
        this.imageId = imageId;
        this.image = image;
        this.photoData = photoData;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getPinCode() {
        return pinCode;
    }

    public void setPinCode(List<String> pinCode) {
        this.pinCode = pinCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    public String getPhotoData() {
        return photoData;
    }

    public void setPhotoData(String photoData) {
        this.photoData = photoData;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", pinCode=" + pinCode +
                ", category='" + category + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", sellerEmail='" + sellerEmail + '\'' +
                ", reviews=" + reviews +
                ", date=" + date +
                ", imageId='" + imageId + '\'' +
                ", image=" + image +
                ", photoData='" + photoData + '\'' +
                '}';
    }
}
