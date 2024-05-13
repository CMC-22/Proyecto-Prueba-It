package com.sena.ShoeStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ShoeStore.interfaceService.IclienteService;
import com.sena.ShoeStore.interfaces.Icliente;
import com.sena.ShoeStore.model.cliente;

@Service
public class clienteService implements IclienteService {
	
	@Autowired
	private Icliente data;
	
	@Override
	public String save(cliente cliente) {
		data.save(cliente);
		return cliente.getId_cliente();
	}
	
	@Override
	public List<cliente> findAll() {
		List<cliente> ListaCliente = (List<cliente>) data.findAll();
		return ListaCliente;
	}
	
	@Override
	public List<cliente>clienteActivo(){
		List<cliente>ListaClienteActivo = data.clienteActivo("Activo");
		return ListaClienteActivo;
	}
	
	@Override
	public List<cliente>filtroCliente(String filtro){
		List<cliente>ListaCliente = data.filtroCliente(filtro);
		return ListaCliente;
	}
	
	@Override
	public Optional<cliente>findOne(String id_cliente) {
		Optional<cliente>cliente = data.findById(id_cliente);
		return cliente;
	}
	
	@Override
	public int delete(String id_cliente) {
		data.deleteById(id_cliente);
		return 1;
	}
	
	@Override
	public boolean existsByNumeroDocumento(String numero_documento) {
		List<cliente>existe = data.existsByNumeroDocumento(numero_documento);
		if (existe.isEmpty()) {
			return false;
		}
		return true;
	}
}
