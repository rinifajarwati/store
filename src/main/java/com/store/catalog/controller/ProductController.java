package com.store.catalog.controller;

import com.store.catalog.entity.Category;
import com.store.catalog.entity.Product;
import com.store.catalog.service.CategoryService;
import com.store.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable("id") String id){
        return productService.findById(id);
    }
    @PostMapping("/products")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }
    @PutMapping("/products")
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }
    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable("id") String id){
        productService.deletedById(id);
    }
    @GetMapping("/categories/{categoryName}")
    public List<Product> getProductsByCategoryName(@PathVariable String categoryName) {
        return productService.getProductsByCategoryName(categoryName);
    }
}
