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

import interfacesService.IventaService;
import model.venta;

@RequestMapping("/api/v1/venta")
@RestController
@CrossOrigin
public class ventaController {
	
	@Autowired
	private IventaService ventaService;
	
	@PostMapping("/")
	public ResponseEntity<Object> save(@RequestBody venta venta){
		ventaService.save(venta);
		return new ResponseEntity<>(venta,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> findAll() {
		var ListaVenta = ventaService.findAll();
		return new ResponseEntity<>(ListaVenta, HttpStatus.OK);
	}
	
	@GetMapping("/ventasActivos")
	public ResponseEntity<Object> ventaActivos(){
		var ListaVenta = ventaService.ventaActivos();
		return new ResponseEntity<>(ListaVenta, HttpStatus.OK);
	}
	
	@GetMapping("/busquedaFiltro/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
		var ListaVenta = ventaService.filtroVenta(filtro);
		return new ResponseEntity<>(ListaVenta, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable char id){
		var venta = ventaService.findOne(id);
		return new ResponseEntity<>(venta,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminarPermanente/{id}")
	public ResponseEntity<Object> delete(@PathVariable char id){
		ventaService.delete(id);
		return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable char id, @RequestBody model.venta ventaUpdate){
		var venta = ventaService.findOne(id).get();
		if (venta != null) {
			venta.setTotal(ventaUpdate.getTotal());
			venta.setEstado(ventaUpdate.getEstado());
			venta.setFecha_venta(ventaUpdate.getFecha_venta());
			ventaService.save(venta);
			return new ResponseEntity<>(venta, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Error venta no encontrada",HttpStatus.BAD_REQUEST);
		}
	}

}
