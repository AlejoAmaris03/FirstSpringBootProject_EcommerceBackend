package com.springboot.ecommerce_backend.controllers;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.springboot.ecommerce_backend.models.Product;
import com.springboot.ecommerce_backend.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/products")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(this.productService.getProducts());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(this.productService.getProductById(id));
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) throws IOException {
        Product product = this.productService.getProductById(id);

        return ResponseEntity.ok()
            .contentType(MediaType.valueOf(product.getImageType()))
            .body(product.getImageData());
    }

    @PostMapping("/register")
    public ResponseEntity<Product> registerProduct(@RequestPart Product product, 
        @RequestPart MultipartFile image) throws IOException {
        return ResponseEntity.ok(this.productService.registerProduct(product, image));
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(this.productService.updateProduct(product));
    }

    @PutMapping("/updateImageProduct")
    public ResponseEntity<Product> updateImageProduct(@RequestPart String productId,
        @RequestPart MultipartFile image) throws IOException {
        return ResponseEntity.ok(this.productService.updateImageProduct(productId, image));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        this.productService.deleteProduct(id);
        return ResponseEntity.ok().body(null);
    }
}
