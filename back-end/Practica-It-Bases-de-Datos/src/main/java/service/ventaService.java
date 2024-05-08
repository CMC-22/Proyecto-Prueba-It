package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import interfaces.Iventa;
import interfacesService.IventaService;
import model.venta;

@Service
public class ventaService implements IventaService {
	@Autowired
	private Iventa data;
	
	@Override
	public char save(venta venta) {
		data.save(venta);
		return venta.getId_venta();
	}
	
	@Override
	public List<venta> findAll() {
		List<venta> ListaVenta= (List<venta>) data.findAll();
		return ListaVenta;
	}

	@Override
	public List<venta> ventaActivos() {
		List<venta> ListaVentaActivos = data.ventaActivos("Activo");
		return ListaVentaActivos;
	}

	@Override
	public List<venta> filtroVenta(String filtro) {
		List<venta>ListaVenta=data.filtroVenta(filtro);
		return ListaVenta;
	}
	
	@Override
	public Optional<venta> findOne(char id_venta) {
		Optional<venta>venta=data.findById((long) id_venta);
		return venta;
	}
	
	@Override
	public int delete(char id_venta) {
		data.deleteById(id_venta);
		return 1;
	}


}
