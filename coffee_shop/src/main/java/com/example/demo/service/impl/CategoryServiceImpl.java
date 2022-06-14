package com.example.demo.service.impl;

import com.example.demo.model.entity.Category;
import com.example.demo.model.enums.CategoryNameEnum;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
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
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .map(this::createCategory)
                .forEach(this.categoryRepository::save);
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {

        return this.categoryRepository.findByName(categoryNameEnum)
                .orElse(null);
    }

    private Category createCategory(CategoryNameEnum c) {

        return new Category()
                .setName(c)
                .setNeededTime(c.getNeededTime());
    }
}
