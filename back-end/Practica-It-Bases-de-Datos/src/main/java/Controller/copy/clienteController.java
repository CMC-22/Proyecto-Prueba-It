package Controller.copy;

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

import interfacesService.IclienteService;
import model.cliente;

@RequestMapping("/api/v1/cliente")
@RestController
@CrossOrigin
public class clienteController {


	@Autowired
	private IclienteService clienteService;
	
	@PostMapping("/")
	public ResponseEntity<Object> save(@RequestBody cliente cliente){
		clienteService.save(cliente);
		return new ResponseEntity<>(cliente,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> findAll() {
		var ListaCliente = clienteService.findAll();
		return new ResponseEntity<>(ListaCliente, HttpStatus.OK);
	}
	
	@GetMapping("/productoActivos")
	public ResponseEntity<Object> productoActivos(){
		var ListaCliente = clienteService.clienteActivos();
		return new ResponseEntity<>(ListaCliente, HttpStatus.OK);
	}
	
	@GetMapping("/busquedaFiltro/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
		var ListaCliente = clienteService.filtroCliente(filtro);
		return new ResponseEntity<>(ListaCliente, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable char id){
		var cliente = clienteService.findOne(id);
		return new ResponseEntity<>(cliente,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminarPermanente/{id}")
	public ResponseEntity<Object> delete(@PathVariable char id){
		clienteService.delete(id);
		return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable char id, @RequestBody cliente clienteUpdate){
		var cliente = clienteService.findOne(id).get();
		if (cliente != null) {
			cliente.setTipo_documento(clienteUpdate.getTipo_documento());
			cliente.setNumero_documento(clienteUpdate.getNumero_documento());
			cliente.setNombre_cliente(clienteUpdate.getNombre_cliente());
			cliente.setApellido_cliente(clienteUpdate.getApellido_cliente());
			cliente.setTelefono(clienteUpdate.getTelefono());
			cliente.setDireccion(clienteUpdate.getDireccion());
			cliente.setCiudad(clienteUpdate.getCiudad());
			cliente.setCorreo_electronico(clienteUpdate.getCorreo_electronico());
			cliente.setEstado(clienteUpdate.getEstado());
			clienteService.save(cliente);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Error venta no encontrada",HttpStatus.BAD_REQUEST);
		}
	}
}
