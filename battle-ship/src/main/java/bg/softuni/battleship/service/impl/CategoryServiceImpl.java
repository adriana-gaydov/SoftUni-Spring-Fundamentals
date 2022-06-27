package bg.softuni.battleship.service.impl;

import bg.softuni.battleship.model.entity.Category;
import bg.softuni.battleship.model.enums.CategoryNameEnum;
import bg.softuni.battleship.repository.CategoryRepository;
import bg.softuni.battleship.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

        List<Category> categories = Arrays.stream(CategoryNameEnum.values())
                .map(c -> new Category()
                        .setName(c)
                        .setDescription(c.name() + " description..."))
                .toList();

        this.categoryRepository.saveAll(categories);
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum category) {

        return this.categoryRepository.findByName(category)
                .orElse(null);
    }
}
