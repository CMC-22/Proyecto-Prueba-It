package interfacesService;

import java.util.List;
import java.util.Optional;

import model.cliente;



public interface IclienteService {
	public char save (cliente cliente);
	public List<cliente>findAll();
	public List<cliente> clienteActivos();
	public Optional<cliente> findOne(char id_cliente);
	public int delete(char id_cliente);
	List<cliente> filtroCliente(String filtro);
	boolean existsByNumerodocumento(String numero_documento);

}
