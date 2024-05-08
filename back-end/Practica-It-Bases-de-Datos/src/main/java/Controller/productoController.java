package Controller;

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

import interfacesService.IproductoService;
import model.producto;


@RequestMapping("/api/v1/producto")
@RestController
@CrossOrigin
public class productoController {
	
	@Autowired
	private IproductoService productoService;
	
	@PostMapping("/")
	public ResponseEntity<Object> save(@RequestBody producto producto){
		productoService.save(producto);
		return new ResponseEntity<>(producto,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> findAll() {
		var ListaProducto = productoService.findAll();
		return new ResponseEntity<>(ListaProducto, HttpStatus.OK);
	}
	
	@GetMapping("/productoActivos")
	public ResponseEntity<Object> productoActivos(){
		var ListaProducto = productoService.productoActivos();
		return new ResponseEntity<>(ListaProducto, HttpStatus.OK);
	}
	
	@GetMapping("/busquedaFiltro/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
		var ListaProducto = productoService.filtroProducto(filtro);
		return new ResponseEntity<>(ListaProducto, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable char id){
		var producto = productoService.findOne(id);
		return new ResponseEntity<>(producto,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminarPermanente/{id}")
	public ResponseEntity<Object> delete(@PathVariable char id){
		productoService.delete(id);
		return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable char id, @RequestBody producto productoUpdate){
		var producto = productoService.findOne(id).get();
		if (producto != null) {
			producto.setNombre_producto(productoUpdate.getNombre_producto());
			producto.setDescripcion(productoUpdate.getDescripcion());
			producto.setCantidad(productoUpdate.getCantidad());
			producto.setPrecio(productoUpdate.getPrecio());
			producto.setPorcentaje_iva(productoUpdate.getPorcentaje_iva());
			producto.setPorcentaje_descuento(productoUpdate.getPorcentaje_descuento());
			producto.setEstado(productoUpdate.getEstado());
			productoService.save(producto);
			return new ResponseEntity<>(producto, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Error venta no encontrada",HttpStatus.BAD_REQUEST);
		}
	}

}
