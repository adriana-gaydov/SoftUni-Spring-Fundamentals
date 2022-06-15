package bg.softuni.shoppinglist.service;

import bg.softuni.shoppinglist.model.entity.Category;
import bg.softuni.shoppinglist.model.enums.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum category);
}
