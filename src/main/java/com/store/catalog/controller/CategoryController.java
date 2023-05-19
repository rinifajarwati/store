package com.store.catalog.controller;

import com.store.catalog.entity.Category;
import com.store.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> findAll(){
        return categoryService.findAll();
    }
    @GetMapping("/categories/{id}")
    public Category findById(@PathVariable("id") String id){
        return categoryService.findById(id);
    }
    @PostMapping("/categories")
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }
    @PutMapping("/categories")
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }
    @DeleteMapping("/categories/{id}")
    public void deleteById(@PathVariable("id") String id){
        categoryService.deletedById(id);
    }
}
