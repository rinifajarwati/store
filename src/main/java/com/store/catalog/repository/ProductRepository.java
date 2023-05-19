package com.store.catalog.repository;

import com.store.catalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findByCategoryName(String categoryName);
}
