package com.vg.userservice.controller;

import com.vg.userservice.dao.UserRepository;
import com.vg.userservice.model.AuthenticationRequest;
import com.vg.userservice.model.User;
import com.vg.userservice.service.MyUserDetailsService;
import com.vg.userservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public String createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());


        // Fetch user roles from the database (assuming roles are stored in User object)
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new Exception("User not found"));
        String roles = user.getRoles();
        final String jwt = jwtUtil.generateToken(userDetails.getUsername(), roles);
        return jwt;
    }
}

