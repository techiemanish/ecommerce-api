package com.ecommerce.login.model;

import com.ecommerce.address.model.Address;
import com.ecommerce.order.model.Order;
import com.ecommerce.product.model.Product;
import com.ecommerce.review.model.Review;

import java.util.List;

public class LoginResponse {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private boolean isSeller;
    private List<Address> address;
    private List<Order> orders;
    private List<Review> reviews;
    private List<Product> products;

    public LoginResponse() {
    }

    public LoginResponse(String firstname, String lastname, String email, String phone, boolean isSeller, List<Address> address, List<Order> orders, List<Review> reviews, List<Product> products) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.isSeller = isSeller;
        this.address = address;
        this.orders = orders;
        this.reviews = reviews;
        this.products = products;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isSeller=" + isSeller +
                ", address=" + address +
                ", orders=" + orders +
                ", reviews=" + reviews +
                ", products=" + products +
                '}';
    }
}
