package com.store.catalog.repository;

import com.store.catalog.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasesItemRepository extends JpaRepository<Order, String>{
}
