package hu.mundgus.udemxcarrent.controller;

import hu.mundgus.udemxcarrent.dto.CarDto;
import hu.mundgus.udemxcarrent.dto.CarImageDto;
import hu.mundgus.udemxcarrent.model.Car;
import hu.mundgus.udemxcarrent.model.CarImage;
import hu.mundgus.udemxcarrent.repository.CarImageRepository;
import hu.mundgus.udemxcarrent.repository.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class CarController {

    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/api/cars")
    public List<CarDto> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(this::toCarDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/api/cars/{startDate}/{endDate}")
    public List<CarDto> getAvailableCars(
            @PathVariable LocalDate startDate,
            @PathVariable LocalDate endDate
    ) {
        return carRepository.findAvailableCars(startDate, endDate)
                .stream()
                .map(this::toCarDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/api/cars")
    public CarDto createCar(
            @RequestBody CarDto carDto
    ) {
        Car car = new Car();
        car.setName(carDto.getName());
        car.setPlateNumber(carDto.getPlateNumber());
        car.setDailyFee(carDto.getDailyFee());
        car.setFuelType(carDto.getFuelType());
        car.setFuelConsumption(carDto.getFuelConsumption());
        car.setActive(true);
        car.setDescription(carDto.getDescription());

        List<CarImage> images = carDto.getImages().stream().map(imgDto -> {
            CarImage image = new CarImage();
            image.setId(imgDto.getId());
            image.setRank(imgDto.getRank());
            image.setImageUrl(imgDto.getUrl());
            image.setCar(car);
            return image;
        }).collect(Collectors.toList());

        car.setCarImages(images);

        carRepository.save(car);
        return carDto;
    }

    @PutMapping("/api/cars/{id}")
    public ResponseEntity<CarDto> updateCar(
            @PathVariable Long id,
            @RequestBody CarDto carDto
    ) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Car car = optionalCar.get();
        car.setName(carDto.getName());
        car.setPlateNumber(carDto.getPlateNumber());
        car.setDailyFee(carDto.getDailyFee());
        car.setFuelType(carDto.getFuelType());
        car.setFuelConsumption(carDto.getFuelConsumption());
        car.setDescription(carDto.getDescription());
        car.setActive(carDto.getActive());


        Map<Integer, CarImage> existingImages = car.getCarImages().stream()
                .collect(Collectors.toMap(CarImage::getRank, img -> img));

        List<CarImage> updatedImages = new ArrayList<>();

        for (CarImageDto imgDto : carDto.getImages()) {
            CarImage image = existingImages.get(imgDto.getRank());

            if (image == null) {
                image = new CarImage();
                image.setCar(car);
            }

            image.setRank(imgDto.getRank());
            image.setImageUrl(imgDto.getUrl());

            updatedImages.add(image);
        }

        car.getCarImages().removeIf(img -> !updatedImages.contains(img));

        car.getCarImages().clear();
        car.getCarImages().addAll(updatedImages);

        carRepository.save(car);
        return ResponseEntity.ok(carDto);
    }

    private CarDto toCarDto(Car car) {
        CarDto carDto = new CarDto();

        carDto.setId(car.getId());
        carDto.setName(car.getName());
        carDto.setPlateNumber(car.getPlateNumber());
        carDto.setDailyFee(car.getDailyFee());
        carDto.setFuelType(car.getFuelType());
        carDto.setFuelConsumption(car.getFuelConsumption());
        carDto.setActive(car.getActive());
        carDto.setDescription(car.getDescription());

        List<CarImageDto> carImages = car.getCarImages().stream()
                        .map(img -> {
                            CarImageDto carImageDto = new CarImageDto();
                            carImageDto.setId(img.getId());
                            carImageDto.setRank(img.getRank());
                            carImageDto.setUrl(img.getImageUrl());
                            return carImageDto;
                        })
                        .collect(Collectors.toList());
        carDto.setImages(carImages);

        return carDto;
    }
}