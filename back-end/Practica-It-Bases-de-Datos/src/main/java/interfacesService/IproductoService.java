package interfacesService;

import java.util.List;
import java.util.Optional;
import model.producto;

public interface IproductoService {
	public char save (producto producto);
	public List<producto>findAll();
	public List<producto> productoActivos();
	public Optional<producto> findOne(char id_producto);
	public int delete(char id_producto);
	List<producto> filtroProducto(String filtro);

}
