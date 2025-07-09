package com.springboot.ecommerce_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.ecommerce_backend.models.Role;

@Repository

public interface RoleRepository extends JpaRepository<Role, Integer>{
    public Role findByName(String name);
}
