package com.springboot.ecommerce_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.springboot.ecommerce_backend.dto.UserDto;
import com.springboot.ecommerce_backend.models.User;
import com.springboot.ecommerce_backend.repositories.UserRepository;

@Service

public class AuthService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerCustomer(User user) {
        if(this.userRepo.findUserByUsername(user.getUsername()) == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            return this.userRepo.save(user);
        }

        return null;
    }

    public UserDto authenticateUser(User user) {
        try {
            Authentication authentication = 
                this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            if(authentication.isAuthenticated()) {
                UserDto userDto = this.getUserByUsername(user.getUsername());
                userDto.setToken(this.jwtService.generateToken(user.getUsername()));

                return userDto;
            }

            return null;
        } 
        catch (Exception e) {
            return null;
        }
    }

    private UserDto getUserByUsername(String username) {
        User user = this.userRepo.findUserByUsername(username);

        return new UserDto(
            user.getId(), 
            user.getName(), 
            user.getSurname(), 
            user.getEmail(), 
            user.getUsername(), 
            null,
            user.getRole()
        );
    }
}
