package hu.mundgus.udemxcarrent.controller;

import hu.mundgus.udemxcarrent.repository.CarImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarImageController {

    private final CarImageRepository carImageRepository;

    @Autowired
    public CarImageController(CarImageRepository carImageRepository) {
        this.carImageRepository = carImageRepository;
    }
}