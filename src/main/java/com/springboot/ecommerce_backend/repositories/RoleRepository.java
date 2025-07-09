package com.springboot.ecommerce_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ecommerce_backend.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
}
