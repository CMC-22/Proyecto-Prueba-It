package interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.cliente;

public interface Icliente extends CrudRepository<cliente,Long>{

@Query("SELECT m FROM cliente m WHERE "
			
			+ "m.id_cliente LIKE %?1% OR "
			+ "m.tipo_documento LIKE %?1% OR "
			+ "m.numero_documento LIKE %?1% OR "
			+ "m.nombre_cliente LIKE %?1% OR "
			+ "m.apellido_cliente LIKE %?1% OR "
			+ "m.telefono LIKE %?1% OR "
			+ "m.direccion LIKE %?1% OR "
			+ "m.ciudad LIKE %?1% OR "
			+ "m.correo_electronico LIKE %?1% OR "
			+ "m.estado LIKE %?1%")
	
	List<cliente> filtroCliente(String filtro);

	@Query("SELECT m FROM cliente m WHERE m.estado =?1")
	List<cliente> clienteActivos(String estado);

	@Query("SELECT m FROM cliente m WHERE m.numero_documento =?1")
	List<cliente> existsByNumeroDocumento(String numeroDocumento);

	
	
	Optional<cliente> findById(long id_cliente);
	void deleteById(char id_cliente);


}
