package com.sena.ShoeStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.ShoeStore.interfaceService.IclienteService;
import com.sena.ShoeStore.model.cliente;

@RequestMapping("/api/v1/cliente")
@RestController
@CrossOrigin
public class clienteController {
	
	@Autowired
	private IclienteService clienteService;
	
	@PostMapping("/")
	public ResponseEntity<Object>save(
			@RequestBody com.sena.ShoeStore.model.cliente cliente){
		cliente.crearCliente();
		if(clienteService.existsByNumeroDocumento(cliente.getNumero_documento())) {
			return new ResponseEntity<>("El numero de documento del cliente ya existe", HttpStatus.BAD_REQUEST);
	}
	clienteService.save(cliente);
	return new ResponseEntity<>(cliente,HttpStatus.OK);
}

@GetMapping("/")
public ResponseEntity<Object>findAll(){
	var ListaCliente = clienteService.findAll();
	return new ResponseEntity<>(ListaCliente, HttpStatus.OK);
}

@GetMapping("/clienteActivo")
public ResponseEntity<Object>clienteActivo(){
	var ListaCliente = clienteService.clienteActivo();
	return new ResponseEntity<>(ListaCliente, HttpStatus.OK);
}

@GetMapping("/busquedaFiltro/{filtro}")
public ResponseEntity<Object>findFiltro(@PathVariable String id){
	var cliente = clienteService.findOne(id);
	return new ResponseEntity<>(cliente, HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<Object>findOne(@PathVariable String id){
	var cliente = clienteService.findOne(id);
	return new ResponseEntity<>(cliente, HttpStatus.OK);
}

@DeleteMapping("/eliminarPermanente/{id}")
public ResponseEntity<Object>delete(@PathVariable String id){
	clienteService.delete(id);
	return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
}
 
@PutMapping("/{id}")
public ResponseEntity<Object>update(@PathVariable String id, @RequestBody cliente clienteUpdate){
	var cliente = clienteService.findOne(id).get();
	if (cliente != null) {
		cliente.setTipo_documento(clienteUpdate.getTipo_documento());
		cliente.setNumero_documento(clienteUpdate.getNumero_documento());
		cliente.setNombre_cliente(clienteUpdate.getNombre_cliente());
		cliente.setApellido_cliente(clienteUpdate.getApellido_cliente());
		cliente.setTelefono(clienteUpdate.getTipo_documento());
		cliente.setDireccion(clienteUpdate.getDireccion());
		cliente.setCiudad(clienteUpdate.getCiudad());
		cliente.setCorreo(clienteUpdate.getCorreo());
		cliente.setEstado(clienteUpdate.getEstado());
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>("Error cliente no encontrado", HttpStatus.BAD_REQUEST);
	}
   }
}
