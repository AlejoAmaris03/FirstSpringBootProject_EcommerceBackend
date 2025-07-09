package com.springboot.ecommerce_backend.services;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.springboot.ecommerce_backend.models.Product;
import com.springboot.ecommerce_backend.repositories.ProductRepository;

@Service

public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public List<Product> getProducts() {
        return this.productRepo.findAll();
    }

    public Product getProductById(int id) {
        return this.productRepo.findById(id).get();
    }

    public Product registerProduct(Product product, MultipartFile image) throws IOException {
        product.setImageData(image.getBytes());
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());

        return this.productRepo.save(product);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = this.productRepo.findById(product.getId()).get();

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setStock(product.getStock());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());

        return this.productRepo.save(existingProduct);
    }

    public Product updateImageProduct(String productId, MultipartFile image) throws IOException {
        Product existingProduct = this.productRepo.findById(Integer.parseInt(productId)).get();

        existingProduct.setImageData(image.getBytes());
        existingProduct.setImageName(image.getOriginalFilename());
        existingProduct.setImageType(image.getContentType());

        return this.productRepo.save(existingProduct);
    }

    public void deleteProduct(int id) {
        this.productRepo.deleteById(id);
    }
}
