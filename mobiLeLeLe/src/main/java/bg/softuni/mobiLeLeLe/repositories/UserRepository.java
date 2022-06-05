package bg.softuni.mobiLeLeLe.repositories;

import bg.softuni.mobiLeLeLe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
