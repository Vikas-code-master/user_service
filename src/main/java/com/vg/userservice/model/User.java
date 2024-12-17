package com.vg.userservice.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Builder
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @NotBlank(message = "Username is mandatory")
    private String username;
    @NotBlank(message = "password is mandatory")
    private String password;
    private String roles;
}

