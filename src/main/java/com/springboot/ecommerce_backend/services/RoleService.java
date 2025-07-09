package com.springboot.ecommerce_backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.ecommerce_backend.models.Role;
import com.springboot.ecommerce_backend.repositories.RoleRepository;

@Service

public class RoleService {
    @Autowired
    private RoleRepository roleRepo;

    public List<Role> getRoles() {
        return this.roleRepo.findAll();
    }
}
