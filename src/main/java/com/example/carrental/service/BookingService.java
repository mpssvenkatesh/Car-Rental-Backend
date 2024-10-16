package com.example.carrental.service;

import com.example.carrental.model.Booking;
import com.example.carrental.model.Car;
import com.example.carrental.repository.BookingRepository;
import com.example.carrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    // Create a new booking
    public Booking createBooking(Booking booking) {
        Car car = carRepository.findById(booking.getCar().getId()).orElse(null);
        if (car != null && car.isAvailable()) {
            car.setAvailable(false);  // Mark the car as not available
            carRepository.save(car);   // Update the car status
            return bookingRepository.save(booking);  // Save the booking
        }
        return null;  // Car not available
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get a booking by ID
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    // Delete a booking
    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            Car car = booking.getCar();
            if (car != null) {
                car.setAvailable(true);  // Mark the car as available again
                carRepository.save(car);  // Update the car status
            }
            bookingRepository.deleteById(id);  // Delete the booking
        }
    }
}
