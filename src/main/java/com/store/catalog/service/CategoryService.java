package com.store.catalog.service;

import com.store.catalog.entity.Category;
import com.store.catalog.exeption.ResourceNotFoundException;
import com.store.catalog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category findById(String id){
        return categoryRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Category with id "+id+ "not found"));
    }
    public List<Category>findAll(){

        return categoryRepository.findAll();
    }
    public Category create(Category category){
        category.setId(UUID.randomUUID().toString());
        return categoryRepository.save(category);
    }
    public Category update(Category category){
        return categoryRepository.save(category);
    }
    public void deletedById(String id){
        categoryRepository.deleteById(id);
    }
}
