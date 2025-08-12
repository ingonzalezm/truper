package com.test.truper.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.truper.models.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
	@Query("SELECT DISTINCT o FROM ordenes o INNER JOIN FETCH u.productos WHERE u.id = :id")
	Optional<Sucursal> findOrdersById(@Param("id") Long id);
}
