package com.example.carapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carapp.entities.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
}
