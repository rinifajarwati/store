package com.store.catalog.repository;

import com.store.catalog.entity.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenggunaRepository extends JpaRepository<Pengguna, String> {
    Boolean existsByEmail(String email);
}
