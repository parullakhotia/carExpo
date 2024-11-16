package com.example.carapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carapp.entities.Car;
import com.example.carapp.repositories.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Add a car
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // Get a car by ID
    public Optional<Car> getCarById(Integer id) {
        return carRepository.findById(id);
    }

    // Get all cars by a user
    public List<Car> getCarsByUser(Integer userId) {
        return carRepository.findAll().stream()
                .filter(car -> car.getUser() != null && car.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }

    // Search cars globally by keyword
    public List<Car> searchCars(String keyword) {
        return carRepository.findAll().stream()
                .filter(car -> car.getTitle() != null && car.getTitle().contains(keyword) || 
                        car.getDescription() != null && car.getDescription().contains(keyword) ||
                        car.getTags() != null && car.getTags().contains(keyword))
                .collect(Collectors.toList());
    }

    // Update a car
    public Car updateCar(Integer id, Car updatedCar) {
        Car existingCar = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        if (updatedCar.getTitle() != null) {
            existingCar.setTitle(updatedCar.getTitle());
        }
        if (updatedCar.getDescription() != null) {
            existingCar.setDescription(updatedCar.getDescription());
        }
        if (updatedCar.getTags() != null) {
            existingCar.setTags(updatedCar.getTags());
        }
        return carRepository.save(existingCar);
    }

    // Delete a car
    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }
}
