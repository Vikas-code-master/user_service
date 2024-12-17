package com.vg.userservice.service;

import com.vg.userservice.dao.UserRepository;
import com.vg.userservice.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Hash the password before saving to the database
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUserByID(@Valid int id) {
        Optional<User> user = userRepository.findById(String.valueOf(id));
        return user.orElse(null);
    }
    public User getUserByName(String name) {
        Optional<User> user = userRepository.findByUsername(name);
        return user.orElse(null);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}

