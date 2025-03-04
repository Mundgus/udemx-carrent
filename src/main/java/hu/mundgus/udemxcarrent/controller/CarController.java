package hu.mundgus.udemxcarrent.controller;

import hu.mundgus.udemxcarrent.dto.CarDto;
import hu.mundgus.udemxcarrent.model.Car;
import hu.mundgus.udemxcarrent.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @PostMapping("/api/cars")
    public CarDto createCar(
            @RequestBody CarDto carDto
    ) {
        carRepository.save(new Car(
                null,
                carDto.getPlateNumber(),
                carDto.getDailyFee(),
                carDto.getFuelType(),
                carDto.getFuelConsumption(),
                carDto.getActive(),
                carDto.getDescription()
        ));
        return carDto;
    }

    private CarDto toCarDto(Car car) {
        CarDto carDto = new CarDto();

        carDto.setId(car.getId());
        carDto.setPlateNumber(car.getPlateNumber());
        carDto.setDailyFee(car.getDailyFee());
        carDto.setFuelType(car.getFuelType());
        carDto.setFuelConsumption(car.getFuelConsumption());
        carDto.setActive(car.getActive());
        carDto.setDescription(car.getDescription());

        return carDto;
    }
}