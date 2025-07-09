package com.springboot.ecommerce_backend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.ecommerce_backend.dto.ReceiptDto;
import com.springboot.ecommerce_backend.dto.SalesDto;
import com.springboot.ecommerce_backend.models.Sale;

@Repository

public interface SalesRepository extends JpaRepository<Sale, Integer>{
    @Query(
    """
        SELECT new com.springboot.ecommerce_backend.dto.SalesDto(s.receiptId, s.user, s.date, CAST(COUNT(s.product) as int), SUM(s.totalPrice))
        FROM Sale s
        GROUP BY s.receiptId, s.user, s.date
        ORDER BY s.receiptId ASC
    """)
    public List<SalesDto> getSalesFiltered();

    @Query(
    """
        SELECT new com.springboot.ecommerce_backend.dto.SalesDto(s.receiptId, s.user, s.date, CAST(COUNT(s.product) as int), SUM(s.totalPrice))
        FROM Sale s
        WHERE s.user.id = ?1
        GROUP BY s.receiptId, s.user, s.date
        ORDER BY s.receiptId ASC
    """)
    public List<SalesDto> getPurchasesFiltered(int id);

    @Query(
    """
        SELECT new com.springboot.ecommerce_backend.dto.ReceiptDto(s.product, s.user, s.date, s.unitPrice, s.quantity, s.totalPrice)
        FROM Sale s
        WHERE s.receiptId = ?1
        ORDER BY s.product ASC
    """)
    public List<ReceiptDto> getSalesByReceiptId(int id);

    @Query(
    """
        SELECT MAX(s.receiptId)
        FROM Sale s
    """)
    public Integer getMaxReceiptId();
}
