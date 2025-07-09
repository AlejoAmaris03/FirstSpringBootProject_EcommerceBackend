package com.springboot.ecommerce_backend.models;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int receiptId;

    @ManyToOne
    @JoinColumn(
        name = "user_id",
        nullable = false
    )
    private User user;

    @ManyToOne
    @JoinColumn(
        name = "product_id",
        nullable = false
    )
    private Product product;

    @Column(nullable = false)
    private Date date; 

    @Column(nullable = false)
    private Long unitPrice; 

    @Column(nullable = false)
    private int quantity; 

    @Column(nullable = false)
    private Long totalPrice; 
}
