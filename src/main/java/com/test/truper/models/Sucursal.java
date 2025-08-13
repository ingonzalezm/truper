package com.test.truper.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="SUCURSALES")
public class Sucursal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4492625340577069756L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sucursal_id")
	@Id
	private Long sucursalId;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
	private List<Orden> ordenes;
	

}
