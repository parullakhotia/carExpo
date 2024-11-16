package com.example.carapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carapp.entities.Image;
import com.example.carapp.services.ImageService;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<Image> addImage(@RequestBody Image image) {
        return ResponseEntity.ok(imageService.addImage(image));
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<Image>> getImagesByCar(@PathVariable Integer carId) {
        return ResponseEntity.ok(imageService.getImagesByCarId(carId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable Integer id) {
        imageService.deleteImage(id);
        return ResponseEntity.ok("Image deleted successfully");
    }
}
