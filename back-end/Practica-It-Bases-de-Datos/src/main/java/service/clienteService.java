package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import interfaces.Icliente;
import interfacesService.IclienteService;
import model.cliente;


@Service
public class clienteService implements IclienteService{
	@Autowired
	private Icliente data;
	
	@Override
	public char save(model.cliente cliente) {
		data.save(cliente);
		return cliente.getId_cliente();
	}
	
	@Override
	public List<cliente> findAll() {
		List<cliente> ListaCliente= (List<cliente>) data.findAll();
		return ListaCliente;
	}

	@Override
	public List<cliente> clienteActivos() {
		List<cliente> ListaClientesActivos = data.clienteActivos("Activo");
		return ListaClientesActivos;
	}

	@Override
	public List<cliente> filtroCliente(String filtro) {
		List<cliente>ListaCliente=data.filtroCliente(filtro);
		return ListaCliente;
	}
	
	@Override
	public Optional<cliente> findOne(char id_cliente) {
		Optional<cliente>cliente=data.findById((long) id_cliente);
		return cliente;
	}
	
	@Override
	public int delete(char id_cliente) {
		data.deleteById(id_cliente);
		return 1;
	}

	public boolean existsByNumerodocumento(String numero_documento){
		List<cliente> existe = data.existsByNumeroDocumento(numero_documento);
		if (existe.isEmpty()){
			return true;
		}
		return true;
	}
}
