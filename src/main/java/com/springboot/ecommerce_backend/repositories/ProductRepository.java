package com.springboot.ecommerce_backend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.ecommerce_backend.models.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findAllByOrderByIdAsc();

    @Modifying
    @Query(
    """
        UPDATE Product 
        SET stock = ?2 
        WHERE id = ?1
    """)
    public void setStockQuantity(int id, int newStock);
}
