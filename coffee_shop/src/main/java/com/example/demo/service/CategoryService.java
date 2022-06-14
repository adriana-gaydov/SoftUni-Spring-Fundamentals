package com.example.demo.service;

import com.example.demo.model.entity.Category;
import com.example.demo.model.enums.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
