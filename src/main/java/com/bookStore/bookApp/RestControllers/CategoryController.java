package com.bookStore.bookApp.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookStore.bookApp.Entities.Category;
import com.bookStore.bookApp.Services.impl.CategoriesServiceImpl;

@RestController
@RequestMapping("/api/")
public class CategoryController {

    @Autowired
    CategoriesServiceImpl categoriesService;
    
    @GetMapping("categories")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categories = categoriesService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("categories/category")
    public ResponseEntity<String> saveCategory(@RequestBody Category category){
        categoriesService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category crated success");
    }
    @GetMapping("categories/category/{id}")
    public ResponseEntity<Category> getOneCategory(@PathVariable("id") Long id){
        Category category = categoriesService.findOneById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(category);
    }

    @PutMapping("categories/category/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable("id") Long id ,@RequestBody Category category){
      
        categoriesService.update(category,id);

        return ResponseEntity.status(HttpStatus.OK).body("category update successfully");
    }

    @DeleteMapping("categories/category/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id") Long id) {
        categoriesService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
