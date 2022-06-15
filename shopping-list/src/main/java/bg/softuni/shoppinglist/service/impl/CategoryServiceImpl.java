package bg.softuni.shoppinglist.service.impl;

import bg.softuni.shoppinglist.model.entity.Category;
import bg.softuni.shoppinglist.model.enums.CategoryNameEnum;
import bg.softuni.shoppinglist.repository.CategoryRepository;
import bg.softuni.shoppinglist.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if (this.categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(c -> {
                    Category category = createCategory(c);

                    this.categoryRepository.save(category);
                });
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum category) {

        return this.categoryRepository.findByName(category)
                .orElse(null);
    }

    private Category createCategory(CategoryNameEnum c) {

        Category category = new Category();
        category.setName(c);
        category.setDescription(c + " description...");

        return category;
    }
}
