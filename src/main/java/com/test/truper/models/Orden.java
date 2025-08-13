package com.test.truper.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ORDENES")
public class Orden implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4858796712966827618L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orden_id")
	@Id
	private Long ordenId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sucursal_id")
    @JsonBackReference
	private Sucursal sucursal;
	
	@Column(name="fecha")
	private LocalDate fecha;
	
	@Column(name="total")
	private Double total;
	
	@OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
	private List<Producto> productos;

}
