package com.example.Practica.It.Bases.de.Datos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practica.It.Bases.de.Datos.interfaceService.IproductoService;
import com.example.Practica.It.Bases.de.Datos.model.productos;

@RequestMapping("api/v1/productos")
@RestController
@CrossOrigin
public class productosController {
    @Autowired
    private IproductoService productoService;

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody productos productos) {
        productoService.save(productos);
        return new ResponseEntity<>(productos,HttpStatus.OK);
    }

    @GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var Listaproductos=productoService.findAll();
		return new ResponseEntity<>(Listaproductos,HttpStatus.OK);
	}

	@GetMapping("/pacientesactivos")
	public ResponseEntity<Object> productosActivos(){
		var Listaproductos=productoService.productosActivos();
		return new ResponseEntity<>(Listaproductos, HttpStatus.OK);
	}
	
	@GetMapping("/busquedafiltro/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
		var Listaproductos=productoService.filtroProductos(filtro);
		return new ResponseEntity<>(Listaproductos, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable String id){
		var productos=productoService.findOne(id);
		return new ResponseEntity<>(productos,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminarPermanente/{id}")
	public ResponseEntity<Object> delete(@PathVariable String id){
		productoService.delete(id);
		return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
	}
}