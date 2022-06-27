package bg.softuni.battleship.repository;

import bg.softuni.battleship.model.entity.Category;
import bg.softuni.battleship.model.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryNameEnum category);
}
