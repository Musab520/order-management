package com.example.ordermanagement.repository;

import com.example.ordermanagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    Optional<Users> findByEmail(String email);
    @Query("SELECT new Users(u.id, u.username, u.email, u.password) from Users u where u.username = :username")
    Users findByUsername(String username);
}
