package com.springboot.ecommerce_backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.ecommerce_backend.models.Role;
import com.springboot.ecommerce_backend.services.RoleService;

@RestController
@RequestMapping("/roles")

public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getUsers() {
        return ResponseEntity.ok(this.roleService.getRoles());
    }
}
