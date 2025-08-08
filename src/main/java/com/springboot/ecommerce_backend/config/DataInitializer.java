package com.springboot.ecommerce_backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.springboot.ecommerce_backend.models.Category;
import com.springboot.ecommerce_backend.models.Role;
import com.springboot.ecommerce_backend.models.User;
import com.springboot.ecommerce_backend.repositories.CategoryRepository;
import com.springboot.ecommerce_backend.repositories.RoleRepository;
import com.springboot.ecommerce_backend.repositories.UserRepository;
import com.springboot.ecommerce_backend.services.UserService;

@Component

public class DataInitializer {
    @SuppressWarnings("unused")
    @Bean
    public CommandLineRunner initRoles(RoleRepository roleRepo) {
        return roles -> {
            // Default roles
            if(roleRepo.findByName("ROLE_ADMIN") == null)
                roleRepo.save(new Role(0, "ROLE_ADMIN"));
                
            if(roleRepo.findByName("ROLE_CUSTOMER") == null)
                roleRepo.save(new Role(0, "ROLE_CUSTOMER"));
        };
    }

    @SuppressWarnings("unused")
    @Bean 
    public CommandLineRunner initCategories(CategoryRepository categoryRepo) {
        return cat -> {
            // Default categories
            if(categoryRepo.findByName("Pants") == null)
                categoryRepo.save(new Category(0, "Pants"));

            if(categoryRepo.findByName("Shoes") == null)
                categoryRepo.save(new Category(0, "Shoes"));

            if(categoryRepo.findByName("Sportswear") == null)
                categoryRepo.save(new Category(0, "Sportswear"));
            
            if(categoryRepo.findByName("Other") == null)
                categoryRepo.save(new Category(0, "Other"));
        };
    }

    @SuppressWarnings("unused")
    @Bean 
    public CommandLineRunner initUsers(UserRepository userRepo, UserService userService) {
        return cat -> {
            // Default admin acc
            if(userRepo.findUserByUsername("admin") == null) {
                userService.registerUser(new User(
                    0,
                    "Admin",
                    "Surname",
                    "admin@example.com",
                    "admin",
                    "123",
                    new Role(1, "ROLE_ADMIN")
                ), "register");
            }
        };
    }
}
