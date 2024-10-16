package com.example.carrental.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // Primary key
    private String make;  // Make of the car (e.g., Toyota)
    private String model; // Model of the car (e.g., Camry)
    private int year;     // Year of manufacture
    private double price; // Rental price per day
    private boolean available; // Availability status

}

