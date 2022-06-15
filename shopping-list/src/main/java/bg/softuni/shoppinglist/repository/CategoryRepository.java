package bg.softuni.shoppinglist.repository;

import bg.softuni.shoppinglist.model.entity.Category;
import bg.softuni.shoppinglist.model.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryNameEnum category);
}
