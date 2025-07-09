package com.springboot.ecommerce_backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.ecommerce_backend.dto.ReceiptDto;
import com.springboot.ecommerce_backend.dto.SalesDto;
import com.springboot.ecommerce_backend.models.Sale;
import com.springboot.ecommerce_backend.services.SaleService;

@RestController
@RequestMapping("/sales")

public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<List<SalesDto>> getSales() {
        return ResponseEntity.ok(this.saleService.getSales());
    }

    @GetMapping("/receipt/{id}")
    public ResponseEntity<List<ReceiptDto>> getSalesByReceiptId(@PathVariable int id) {
        return ResponseEntity.ok(this.saleService.getSalesByReceiptId(id));
    }

    @GetMapping("/purchases/{id}")
    public ResponseEntity<List<SalesDto>> getPurchasesByUserId(@PathVariable int id) {
        return ResponseEntity.ok(this.saleService.getPurchasesByUserId(id));
    }

    @GetMapping("/purchases/receipt/{id}")
    public ResponseEntity<List<ReceiptDto>> getPurchasesByReceiptId(@PathVariable int id) {
        return ResponseEntity.ok(this.saleService.getSalesByReceiptId(id));
    }

    @PostMapping("/buy")
    public ResponseEntity<List<Sale>> saveSale(@RequestPart String userId, @RequestPart List<Sale> products) {
        return ResponseEntity.ok(this.saleService.saveSale(userId, products));
    }
}
