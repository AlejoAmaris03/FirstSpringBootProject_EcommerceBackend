package com.springboot.ecommerce_backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.ecommerce_backend.models.User;
import com.springboot.ecommerce_backend.services.UserService;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(this.userService.getUsers());
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(this.userService.getUserById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestPart User user, @RequestPart String action) {
        return ResponseEntity.ok(this.userService.registerUser(user, action));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
        return ResponseEntity.ok().body(null);
    }
}
