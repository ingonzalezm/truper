package com.test.truper.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.truper.models.Orden;


public interface OrdenRepository extends JpaRepository<Orden, Long> {
	Optional<Orden> findByOrdenIdAndSucursalSucursalId(Long userId, Long ordenId);
}
