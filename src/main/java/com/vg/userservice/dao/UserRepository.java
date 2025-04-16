package com.vg.userservice.dao;

import com.vg.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
//    @Query("select * from user where username = :username")
    Optional<User> findByUsername(String username);
}


