package hu.mundgus.udemxcarrent.repository;

import hu.mundgus.udemxcarrent.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByPlateNumber(String plateNumber);

    @Query("SELECT c FROM Car c WHERE c.isActive = true AND c.id NOT IN (" +
            "SELECT b.car.id FROM Booking b " +
            "WHERE (b.startDate <= :endDate AND b.endDate >= :startDate))")
    List<Car> findAvailableCars(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
