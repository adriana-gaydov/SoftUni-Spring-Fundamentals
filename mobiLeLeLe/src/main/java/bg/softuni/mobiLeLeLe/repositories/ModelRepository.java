package bg.softuni.mobiLeLeLe.repositories;

import bg.softuni.mobiLeLeLe.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
