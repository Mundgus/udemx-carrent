package hu.mundgus.udemxcarrent.repository;

import hu.mundgus.udemxcarrent.model.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepository extends JpaRepository<CarImage, Long> {
}
