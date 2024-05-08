package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import interfaces.Iproducto;
import interfacesService.IproductoService;
import model.producto;

@Service
public class productoService implements IproductoService {
	@Autowired
	private Iproducto data;
	
	@Override
	public char save(producto producto) {
		data.save(producto);
		return producto.getId_producto();
	}
	
	@Override
	public List<producto> findAll() {
		List<producto> ListaProducto= (List<producto>) data.findAll();
		return ListaProducto;
	}

	@Override
	public List<producto> productoActivos() {
		List<producto> ListaProductoActivos = data.productoActivos("Activo");
		return ListaProductoActivos;
	}

	@Override
	public List<producto> filtroProducto(String filtro) {
		List<producto>ListaProducto=data.filtroProducto(filtro);
		return ListaProducto;
	}
	
	@Override
	public Optional<producto> findOne(char id_producto) {
		Optional<producto>producto=data.findById((long) id_producto);
		return producto;
	}
	
	@Override
	public int delete(char id_producto) {
		data.deleteById(id_producto);
		return 1;
	}

}
