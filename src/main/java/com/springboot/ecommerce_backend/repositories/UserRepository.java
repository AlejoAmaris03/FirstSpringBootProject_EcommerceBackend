package com.springboot.ecommerce_backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.ecommerce_backend.models.User;

@Repository

public interface UserRepository extends JpaRepository<User, Integer>{
    public List<User> findAllByOrderByIdAsc();
    
    public User findUserByUsername(String username);

    @Query(
    """
        SELECT u
        FROM User u
        WHERE u.username != ?1 AND u.username = ?2
    """)
    public User findUniqueUsername(String currentUsername, String newUsername);
}
