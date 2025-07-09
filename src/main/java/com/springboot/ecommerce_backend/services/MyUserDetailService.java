package com.springboot.ecommerce_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.springboot.ecommerce_backend.models.User;
import com.springboot.ecommerce_backend.models.UserPrincipal;
import com.springboot.ecommerce_backend.repositories.UserRepository;

@Service

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("User not found with username: " + username);

        return new UserPrincipal(user);
    }
}
