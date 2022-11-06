package com.bookStore.bookApp.Services.impl;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import com.bookStore.bookApp.Entities.Category;
import com.bookStore.bookApp.Exceptions.AlreadyExist;
import com.bookStore.bookApp.Exceptions.BadRequest;
import com.bookStore.bookApp.Exceptions.NotFound;
import com.bookStore.bookApp.Exceptions.InternalError;
import com.bookStore.bookApp.Repositories.CategoryRepository;
import com.bookStore.bookApp.Services.CategoryService;


@Service
@Transactional
public class CategoriesServiceImpl implements CategoryService {

    private static final Logger log = LoggerFactory.getLogger(CategoriesServiceImpl.class);
    
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        List<Category> categories= categoryRepository.findAll();
        if(categories.size()>0){
            return categories;
        }else{
            throw new NotFound("Categories not found");
        }
    }

    @Override
    public Category findOneByName(String name) {
        Category category= categoryRepository.findByName(name);
        if(category != null){
            return category;
        }else{
            throw new NotFound("there is no category "+name);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        try{
            categoryRepository.deleteById(id);
        }catch(Exception e){
            log.error(e.getMessage());
            throw new InternalError("Fail to delete category");
        }
        
    }

    @Override
    public void saveCategory(Category category) {
        if(category.getName()==null){
            throw new BadRequest("Empty, really? do it right, idiot.");
        }
        Boolean exist= categoryRepository.findByName(category.getName())!=null?true:false;
        if(exist){
            throw new AlreadyExist("category already exists");
        }else{
            try{
                categoryRepository.save(category);
            }catch(JpaSystemException e){
                log.error(e.getMessage());
                throw new InternalError("server error during category save");
            }
        }
    }

    @Override
    public void update(Category category,Long id) {
        try{
            categoryRepository.save(category);
        }catch(JpaSystemException e){
            log.error(e.getMessage());
            throw new InternalError("server error during category update");
        }
    }

    @Override
    public Category findOneById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new NotFound("Category not found");
        }else{
            return category.get();
        }
    }
    
}
