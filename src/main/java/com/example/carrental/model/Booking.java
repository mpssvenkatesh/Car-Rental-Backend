package com.example.carrental.model;


import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Booking{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    @ManyToOne // Many bookings can belong to one user
    private User user;

    @ManyToOne // Many bookings can be for one car
    private Car car;

    private LocalDate startDate; // Start date for the booking
    private LocalDate endDate;   // End date for the booking
}
