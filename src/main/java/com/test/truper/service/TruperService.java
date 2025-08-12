package com.test.truper.service;

import java.util.List;

import com.test.truper.models.Orden;
import com.test.truper.models.Producto;
import com.test.truper.models.Sucursal;

public interface TruperService {
	Orden crearOrden(Long sucursalId, List<Producto> productos);

	Sucursal crearSucursal(Sucursal sucursal);

	Producto actualizarProducto(Long sucursalId, Producto producto);

	Sucursal getOrden(Long sucursalId);
}
