package com.test.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.truper.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	Producto findByCodigo(String codigo);
}
