package bg.softuni.battleship.service;

import bg.softuni.battleship.model.entity.Category;
import bg.softuni.battleship.model.enums.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum category);
}
