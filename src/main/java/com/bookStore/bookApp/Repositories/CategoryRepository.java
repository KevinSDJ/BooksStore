package com.bookStore.bookApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.bookApp.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {


    
    Category findByName(String name);
}
