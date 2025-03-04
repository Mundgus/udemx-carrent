package hu.mundgus.udemxcarrent.controller;

import hu.mundgus.udemxcarrent.dto.CarDto;
import hu.mundgus.udemxcarrent.model.Car;
import hu.mundgus.udemxcarrent.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
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
        carDto.setImages(Arrays.asList(
                "https://storage.googleapis.com/pod_public/1300/173321.jpg",
                "https://imageio.forbes.com/specials-images/imageserve/5d35eacaf1176b0008974b54/0x0.jpg"
        ));

        return carDto;
    }
}