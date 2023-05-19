package com.store.catalog.repository;

import com.store.catalog.entity.OrderLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLogRepository extends JpaRepository<OrderLog,String> {
}
