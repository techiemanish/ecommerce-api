package com.ecommerce.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.util.Date;

@Document(collection = "Order")
public class Order {
    @Id
    private String orderid;
    private int productid;
    private int price;
    private int quantity;
    private int total;
    private String email;
    private Address address;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date date;

    public Order() {
    }

    public Order(String orderid, int productid, int price, int quantity, int total, String email, Address address, Date date) {
        this.orderid = orderid;
        this.productid = productid;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.email = email;
        this.address = address;
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid='" + orderid + '\'' +
                ", productid=" + productid +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total=" + total +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", date=" + date +
                '}';
    }
}
