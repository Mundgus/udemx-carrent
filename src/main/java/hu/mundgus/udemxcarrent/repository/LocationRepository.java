package hu.mundgus.udemxcarrent.repository;

import hu.mundgus.udemxcarrent.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
