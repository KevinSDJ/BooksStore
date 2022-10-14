package com.example.bookApp.Services;

import java.util.List;
import com.example.bookApp.Entities.Category;

public interface CategoryService {

    List<Category> findAll();
    Category findOneByName(String name);
    Category findOneById(Long id);
    void deleteCategory(Long id);
    void saveCategory(Category category);
    void update(Category category,Long id);
}