package com.example.carapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.carapp.entities.Car;
import com.example.carapp.entities.User;
import com.example.carapp.services.CarService;
import com.example.carapp.services.UserService;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    // Add a car and associate it with the logged-in user
    @PostMapping
    public ResponseEntity<?> addCar(@RequestBody Car car, @RequestParam Integer userId) {
        try {
            // Fetch the user by ID
            User user = userService.getUserById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Associate the user with the car
            car.setUser(user);
            Car createdCar = carService.addCar(car);

            return ResponseEntity.ok(createdCar);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get a car by ID
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        Optional<Car> car = carService.getCarById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get cars by user ID
    @GetMapping
    public ResponseEntity<List<Car>> getCarsByUser(@RequestParam Integer userId) {
        return ResponseEntity.ok(carService.getCarsByUser(userId));
    }

    // Search cars globally by keyword
    @GetMapping("/search")
    public ResponseEntity<List<Car>> searchCars(@RequestParam String keyword) {
        return ResponseEntity.ok(carService.searchCars(keyword));
    }

    // Update a car
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Integer id, @RequestBody Car updatedCar, @RequestParam Integer userId) {
        try {
            // Fetch the user by ID
            User user = userService.getUserById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Associate the updated user to the car
            updatedCar.setUser(user);

            Car car = carService.updateCar(id, updatedCar);
            return ResponseEntity.ok(car);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Delete a car
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
        return ResponseEntity.ok("Car deleted successfully");
    }
}
