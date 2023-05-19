package com.store.catalog.repository;

import com.store.catalog.entity.ShippingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingCartRepository extends JpaRepository<ShippingCart, String> {
}
