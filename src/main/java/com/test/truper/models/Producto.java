package com.test.truper.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCTOS")
public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8468606314499040665L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_id")
	@Id
	private Long productoId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orden_id")
	@JsonBackReference
	private Orden orden;

	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio")
	private Double precio;

}
