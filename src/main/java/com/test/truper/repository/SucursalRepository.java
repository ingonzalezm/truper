package com.test.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.truper.models.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
