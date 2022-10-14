package com.example.bookApp.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookApp.Entities.Category;
import com.example.bookApp.Services.impl.CategoriesServiceImpl;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoriesServiceImpl categoriesService;
    
    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categories = categoriesService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
    
    @PostMapping("/category")
    public ResponseEntity<String> saveCategory(@RequestBody Category category){
        categoriesService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category crated success");
    }
    @GetMapping("/category/:id")
    public ResponseEntity<Category> getOneCategory(@PathVariable("id") Long id){
        Category category = categoriesService.findOneById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(category);
    }

    @PutMapping("/category/:id")
    public ResponseEntity<String> updateCategory(@PathVariable("id") Long id ,@RequestBody Category category){
      
        categoriesService.update(category,id);

        return ResponseEntity.status(HttpStatus.OK).body("category update successfully");
    }

    @DeleteMapping("/category/:id")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id") Long id) {
        categoriesService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
