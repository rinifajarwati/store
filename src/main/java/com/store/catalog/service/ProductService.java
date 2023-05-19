package com.store.catalog.service;

import com.store.catalog.entity.Product;
import com.store.catalog.exeption.ResourceNotFoundException;
import com.store.catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(String id){
        return productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product with id "+id+" not found"));
    }
    public Product create(Product product){
        product.setId(UUID.randomUUID().toString());
        return productRepository.save(product);
    }
    public Product update(Product product){
        return productRepository.save(product);
    }
    public void deletedById(String id){
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategoryName(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

}
