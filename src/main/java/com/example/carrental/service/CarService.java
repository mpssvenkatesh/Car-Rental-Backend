package com.example.carrental.service;

import com.example.carrental.model.Car;
import com.example.carrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Get all available cars
    public List<Car> getAvailableCars() {
        return carRepository.findAll();
    }

    // Add a new car
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // Get car by ID
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    // Update a car
    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    // Delete a car
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
