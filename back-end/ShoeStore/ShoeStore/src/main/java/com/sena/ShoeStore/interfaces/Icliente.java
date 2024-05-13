package com.sena.ShoeStore.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sena.ShoeStore.model.cliente;

public interface Icliente extends CrudRepository<cliente,String> {
	
	@Query("SELECT c FROM cliente c WHERE"
			+"c.id_cliente LIKE %?1% OR"
			+"c.tipo_documento LIKE %?1% OR"
			+"c.numero_documento LIKE %?1% OR"
			+"c.nombre_cliente LIKE %?1% OR"
			+"c.apellido_cliente LIKE %?1% OR"
			+"c.telefono LIKE %?1% OR"
			+"c.ciudad LIKE %?1% OR"
			+"c.direccion LIKE %?1% OR"
			+"c.correo LIKE %?1% OR"
			+"c.estado LIKE %?1%")
	List<cliente>filtroCliente(String filtro);
	
	@Query("SELECT c FROM cliente c WHERE c.estado = ?1")
	List<cliente>clienteActivo(String estado);
	
	@Query("SELECT c FROM cliente c WHERE c.numero_documento = ?1")
	List<cliente>existsByNumeroDocumento(String numero_documento);

}
