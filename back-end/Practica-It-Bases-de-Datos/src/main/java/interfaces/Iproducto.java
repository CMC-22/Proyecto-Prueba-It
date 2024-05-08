package interfaces;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import model.producto;


public interface Iproducto extends CrudRepository<producto,Long>{
@Query("SELECT m FROM producto m WHERE "
			
			+ "m.id_producto LIKE %?1% OR "
			+ "m.nombre_producto LIKE %?1% OR "
			+ "m.descripcion LIKE %?1% OR "
			+ "m.cantidad LIKE %?1% OR "
			+ "m.precio LIKE %?1% OR "
			+ "m.porcentaje_iva LIKE %?1% OR "
			+ "m.porcentaje_descuento LIKE %?1% OR "
			+ "m.estado LIKE %?1%")
	
	List<producto> filtroProducto(String filtro);

	@Query("SELECT m FROM producto m WHERE m.estado =?1")
	List<producto> productoActivos(String estado);

	
	Optional<producto> findById(long id_producto);
	void deleteById(char id_producto);

	List<producto> findAll();

}
