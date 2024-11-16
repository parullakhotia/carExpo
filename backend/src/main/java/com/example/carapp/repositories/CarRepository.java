package com.example.carapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carapp.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
