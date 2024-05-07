package com.example.Practica.It.Bases.de.Datos.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Practica.It.Bases.de.Datos.model.productos;

public interface Iproductos extends CrudRepository<productos,char> {

 
    @Query("SELECT m FROM productos m WHERE m. estado =?1")
    List<productos> productosActivos(String estado);

	List<productos> filtroProductos(String filtro);

	Optional<productos> findById(String id_productos);

	void deleteById(char id_productos);



}