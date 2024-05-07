@RequestMapping("api/v1/productos")
@RestController
@CrossOrigin
public class productosController {
    @Autowired
    private IproductoService productoService;

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody productos productos) {
        productoService.save(productos);
        return new ResponseEntity<>(productos,HttpStatus.Ok);
    }

    @GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var Listaproductos=productoService.findAll();
		return new ResponseEntity<>(Listaproductos HttpStatus.OK);
	}

	@GetMapping("/pacientesactivos")
	public ResponseEntity<Object> productosActivos(){
		var Listaproductos=productosService.productosActivos();
		return new ResponseEntity<>(Listaproductos, HttpStatus.OK);
	}
	
	@GetMapping("/busquedafiltro/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
		var Listaproductos=pacienteService.filtroProductos(filtro);
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