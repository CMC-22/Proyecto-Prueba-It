package com.sena.ShoeStore.interfaceService;

import java.util.List;
import java.util.Optional;

import com.sena.ShoeStore.model.cliente;

public interface IclienteService {
	public String save (cliente cliente);
	public List<cliente>findAll();
	public List<cliente>clienteActivo();
	public Optional<cliente>findOne(String id_cliente);
	public int delete(String id_cliente);
	List<cliente>filtroCliente(String filtro);
	boolean existsByNumeroDocumento(String numero_documento);

}
