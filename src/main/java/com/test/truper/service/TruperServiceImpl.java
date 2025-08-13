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
		double total = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
		Orden orden = new Orden();
		orden.setSucursal(sucursal);
		orden.setFecha(LocalDate.now());
		orden.setTotal(total);
		
		productos.forEach(producto -> producto.setOrden(orden));
		orden.setProductos(productos);
		Orden ordens = ordenRepository.save(orden);
		return ordens;
	}

	@Override
	public Sucursal crearSucursal(Sucursal sucursal) {
		return sucursalRepository.save(sucursal);
	}

	@Override
	public Producto actualizarProducto(Long sucursalId, Long ordenId, Producto producto) {
		Orden orden = ordenRepository.findByOrdenIdAndSucursalSucursalId(ordenId, sucursalId).orElseThrow();
		
		Producto product = orden.getProductos().stream().filter(p->p.getCodigo().equals(producto.getCodigo())).findFirst().orElseThrow();
				product.setPrecio(producto.getPrecio());
		double total = orden.getProductos().stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
		orden.setTotal(total);
		ordenRepository.save(orden);
		return product;
	}

	@Override
	public Sucursal getOrdenes(Long sucursalId) {
		return sucursalRepository.findById(sucursalId).orElseThrow();
	}


}
