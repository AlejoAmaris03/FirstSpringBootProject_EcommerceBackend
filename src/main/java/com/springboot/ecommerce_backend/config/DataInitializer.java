package com.springboot.ecommerce_backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.springboot.ecommerce_backend.models.Category;
import com.springboot.ecommerce_backend.models.Role;
import com.springboot.ecommerce_backend.repositories.CategoryRepository;
import com.springboot.ecommerce_backend.repositories.RoleRepository;

@Component

public class DataInitializer {
    @SuppressWarnings("unused")
    @Bean
    public CommandLineRunner initRoles(RoleRepository roleRepo, CategoryRepository categoryRepo) {
        return roles -> {
            // Default roles
            if(roleRepo.findByName("ROLE_ADMIN") == null)
                roleRepo.save(new Role(0, "ROLE_ADMIN"));
                
            if(roleRepo.findByName("ROLE_CUSTOMER") == null)
                roleRepo.save(new Role(0, "ROLE_CUSTOMER"));

            // Default categories
            if(categoryRepo.findByName("Pants") == null)
                categoryRepo.save(new Category(0, "Pants"));

            if(categoryRepo.findByName("Shoes") == null)
                categoryRepo.save(new Category(0, "Shoes"));

            if(categoryRepo.findByName("Sportswear") == null)
                categoryRepo.save(new Category(0, "Sportswear"));
        };
    }
}
