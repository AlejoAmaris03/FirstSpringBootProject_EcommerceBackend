package com.springboot.ecommerce_backend.dto;

import java.util.Date;
import com.springboot.ecommerce_backend.models.Product;
import com.springboot.ecommerce_backend.models.User;

public class ReceiptDto {
    private Product product;
    private User user;
    private Date date;
    private Long unitPrice;
    private int quantity;
    private Long totalPrice;

    public ReceiptDto(Product product, User user, Date date, Long unitPrice, int quantity, Long totalPrice) {
        this.product = product;
        this.user = user;
        this.date = date;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
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
    
    public Long getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
