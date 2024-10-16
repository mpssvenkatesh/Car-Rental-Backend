package com.example.carrental.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key
    private String username; // Username for login
    private String password; // Password for login
    private String role; // Role of the user (USER or ADMIN)
}
