package bg.softuni.shoppinglist.repository;

import bg.softuni.shoppinglist.model.entity.Product;
import bg.softuni.shoppinglist.model.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(CategoryNameEnum name);
}
