package com.example.UserAuthenticationSpringBoot.repository;

import com.example.UserAuthenticationSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
