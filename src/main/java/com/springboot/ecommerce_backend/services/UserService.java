package com.springboot.ecommerce_backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.springboot.ecommerce_backend.models.User;
import com.springboot.ecommerce_backend.repositories.UserRepository;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<User> getUsers() {
        return this.userRepo.findAllByOrderByIdAsc();
    }
    
    public User getUserById(int id) {
        return this.userRepo.findById(id).get();
    }

    public User registerUser(User user, String action) {
        if(action.equals("register")) {
            if(this.userRepo.findUserByUsername(user.getUsername()) == null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));

                return this.userRepo.save(user);
            }
        }
        else {
            User currentUser = this.userRepo.findById(user.getId()).get();

            if(this.userRepo.findUniqueUsername(currentUser.getUsername(), user.getUsername()) == null) {
                currentUser.setName(user.getName());
                currentUser.setSurname(user.getSurname());
                currentUser.setEmail(user.getEmail());
                currentUser.setUsername(user.getUsername());
                currentUser.setPassword(passwordEncoder.encode(user.getPassword()));
                currentUser.setRole(user.getRole());

                return this.userRepo.save(currentUser);
            }
        }

        return null;
    }

    public void deleteUser(int id) {
        this.userRepo.deleteById(id);
    }
}
