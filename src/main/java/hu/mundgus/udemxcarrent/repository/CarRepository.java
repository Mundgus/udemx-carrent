package hu.mundgus.udemxcarrent.repository;

import hu.mundgus.udemxcarrent.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByPlateNumber(String plateNumber);
}
