package com.springboot.ecommerce_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.ecommerce_backend.dto.UserDto;
import com.springboot.ecommerce_backend.models.User;
import com.springboot.ecommerce_backend.services.AuthService;

@RestController
@RequestMapping("/auth")

public class AuthController {
    @Autowired
    private AuthService authService;    
    
    @PostMapping("/registerCustomer")
    public ResponseEntity<User> registerCustomer(@RequestBody User user) {
        return ResponseEntity.ok(this.authService.registerCustomer(user));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserDto> authenticateUser(@RequestBody User user) {
        return ResponseEntity.ok(this.authService.authenticateUser(user));
    }
}
