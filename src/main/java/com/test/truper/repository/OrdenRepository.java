package com.test.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.truper.models.Orden;


public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
