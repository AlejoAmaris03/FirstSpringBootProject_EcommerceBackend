package com.springboot.ecommerce_backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.ecommerce_backend.models.Category;
import com.springboot.ecommerce_backend.repositories.CategoryRepository;

@Service

public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> getCategories() {
        return this.categoryRepo.findAll();
    }
}
