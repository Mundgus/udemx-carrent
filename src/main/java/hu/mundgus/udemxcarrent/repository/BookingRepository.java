package hu.mundgus.udemxcarrent.repository;

import hu.mundgus.udemxcarrent.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
