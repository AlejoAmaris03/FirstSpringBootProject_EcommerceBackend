package com.springboot.ecommerce_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ecommerce_backend.models.Category;

@Repository

public interface CategoryRepository extends JpaRepository<Category, Integer>{
}
