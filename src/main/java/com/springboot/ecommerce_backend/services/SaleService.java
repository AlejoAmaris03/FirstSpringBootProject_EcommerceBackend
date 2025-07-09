package com.springboot.ecommerce_backend.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.ecommerce_backend.dto.ReceiptDto;
import com.springboot.ecommerce_backend.dto.SalesDto;
import com.springboot.ecommerce_backend.models.Sale;
import com.springboot.ecommerce_backend.models.User;
import com.springboot.ecommerce_backend.repositories.ProductRepository;
import com.springboot.ecommerce_backend.repositories.SalesRepository;
import com.springboot.ecommerce_backend.repositories.UserRepository;

@Service

public class SaleService {
    @Autowired
    private SalesRepository salesRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    public List<SalesDto> getSales() {
        return this.salesRepo.getSalesFiltered();
    }

    public List<SalesDto> getPurchasesByUserId(int id) {
        return this.salesRepo.getPurchasesFiltered(id);
    }

    @Transactional
    public List<ReceiptDto> getSalesByReceiptId(int id) {
        return this.salesRepo.getSalesByReceiptId(id);
    }

    @Transactional
    public List<Sale> saveSale(String userId, List<Sale> products) {
        User user = this.userRepo.findById(Integer.parseInt(userId)).get();
        Integer receiptId = this.salesRepo.getMaxReceiptId() != null ? (this.salesRepo.getMaxReceiptId() + 1) : 1;
        Date date = new Date();

        for(Sale sale : products) {
            Long totalPrice = sale.getProduct().getPrice() * sale.getQuantity();

            sale.setDate(date);
            sale.setReceiptId(receiptId);
            sale.setTotalPrice(totalPrice);
            sale.setUnitPrice(sale.getProduct().getPrice());
            sale.setUser(user);

            this.productRepo.setStockQuantity(sale.getProduct().getId(), sale.getProduct().getStock() - sale.getQuantity());
        }

        return this.salesRepo.saveAll(products);
    }
}
