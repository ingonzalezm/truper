package com.test.truper.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.test.truper.models.Orden;
import com.test.truper.models.Producto;
import com.test.truper.models.Sucursal;
import com.test.truper.repository.OrdenRepository;
import com.test.truper.repository.ProductoRepository;
import com.test.truper.repository.SucursalRepository;

@Service
public class TruperServiceImpl implements TruperService{
	
	private OrdenRepository ordenRepository;
	private SucursalRepository sucursalRepository;
	private ProductoRepository productoRepository;
	
	public TruperServiceImpl(OrdenRepository ordenRepository, SucursalRepository sucursalRepository,
			ProductoRepository productoRepository) {
		this.ordenRepository = ordenRepository;
		this.sucursalRepository = sucursalRepository;
		this.productoRepository = productoRepository;
	}

	@Override
	public Orden crearOrden(Long sucursalId, List<Producto> productos) {
		Sucursal sucursal = sucursalRepository.findById(sucursalId).orElseThrow();
		Double total = productos.stream().map(x -> x.getPrecio())
		  .collect(Collectors.summingDouble(Double::doubleValue));
		Orden orden = new Orden();
		orden.setSucursal(sucursal);
		orden.setFecha(LocalDate.now());
		orden.setTotal(total);
		orden.setProductos(productos);
		return ordenRepository.save(orden);
	}

	@Override
	public Sucursal crearSucursal(Sucursal sucursal) {
		return sucursalRepository.save(sucursal);
	}

	@Override
	public Producto actualizarProducto(Long sucursalId, Producto producto) {
		Producto product= productoRepository.findByCodigo(producto.getCodigo());
		product.setPrecio(producto.getPrecio());
		return productoRepository.save(product);
	}

	@Override
	public Sucursal getOrden(Long sucursalId) {
		return sucursalRepository.findById(sucursalId).orElseThrow();
	}


}
