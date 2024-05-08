package interfacesService;

import java.util.List;
import java.util.Optional;
import model.venta;

public interface IventaService {
	public char save (venta venta);
	public List<venta>findAll();
	public List<venta> ventaActivos();
	public Optional<venta> findOne(char id_venta);
	public int delete(char id_venta);
	List<venta> filtroVenta(String filtro);

}
