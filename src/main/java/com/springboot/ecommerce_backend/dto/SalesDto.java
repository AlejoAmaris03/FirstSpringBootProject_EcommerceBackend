package com.springboot.ecommerce_backend.dto;

import java.util.Date;
import com.springboot.ecommerce_backend.models.User;

public class SalesDto {
    private int receiptId;
    private User user;
    private Date date;
    private int products;
    private Long totalPrice;

    public SalesDto(int receiptId, User user, Date date, int products, Long totalPrice) {
        this.receiptId = receiptId;
        this.user = user;
        this.date = date;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public int getReceiptId() {
        return receiptId;
    }
    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public int getProducts() {
        return products;
    }
    public void setProducts(int products) {
        this.products = products;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
