package interfaces.copy;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import model.venta;

public interface Iventa extends CrudRepository<venta,Long> {

@Query("SELECT m FROM venta m WHERE "
			
			+ "m.id_venta LIKE %?1% OR "
			+ "m.total LIKE %?1% OR "
			+ "m.estado LIKE %?1% OR "
			+ "m.fecha_venta LIKE %?1% OR ")
	
	List<venta> filtroVenta(String filtro);

	@Query("SELECT m FROM venta m WHERE m.estado =?1")
	List<venta> ventaActivos(String estado);
	
	Optional<venta> findById(long id_venta);
	void deleteById(char id_venta);
}
