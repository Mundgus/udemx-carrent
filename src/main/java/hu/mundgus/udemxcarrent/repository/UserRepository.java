package hu.mundgus.udemxcarrent.repository;

import hu.mundgus.udemxcarrent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
