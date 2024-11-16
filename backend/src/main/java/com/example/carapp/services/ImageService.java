package com.example.carapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carapp.entities.Image;
import com.example.carapp.repositories.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    public List<Image> getImagesByCarId(Integer carId) {
        return imageRepository.findAll().stream().filter(image -> image.getCar().getId().equals(carId)).toList();
    }

    public void deleteImage(Integer id) {
        imageRepository.deleteById(id);
    }
}
