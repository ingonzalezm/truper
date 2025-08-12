package com.test.truper.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.truper.models.Orden;
import com.test.truper.models.Producto;
import com.test.truper.models.Sucursal;
import com.test.truper.service.TruperService;

@RestController
@RequestMapping("/truper")
public class TruperController {

	private TruperService truperService;

	public TruperController(TruperService truperService) {
		this.truperService = truperService;
	}

	@PostMapping("/ordenes/{sucursalId}")
	public Orden createOrden(@PathVariable Long sucursalId, @RequestBody List<Producto> productos) {
		return truperService.crearOrden(sucursalId, productos);
	}
	
	@GetMapping("/ordenes/{sucursalId}")
	public Sucursal gerOrden(@PathVariable Long sucursalId) {
		return truperService.getOrden(sucursalId);
	}
	
	@PostMapping("/sucursal")
	public Sucursal createSucursal(@RequestBody Sucursal sucursal) {
		return truperService.crearSucursal(sucursal);
	}
	
	@PutMapping("/ordenes/{sucursalId}")
	public Producto actualizarProducto(@PathVariable Long sucursalId, @RequestBody Producto producto) {
		return truperService.actualizarProducto(sucursalId, producto);
	}
}
