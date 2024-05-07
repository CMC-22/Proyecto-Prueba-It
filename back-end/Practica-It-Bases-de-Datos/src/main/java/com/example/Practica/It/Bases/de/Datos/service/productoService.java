package com.example.Practica.It.Bases.de.Datos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Practica.It.Bases.de.Datos.model.productos;

@Service
public class productoService implements IproductoService {
    @Autowired
    private Iproducto data;

    @Override
    public String save(productos productos) {
        data.save(productos);
        return productos.getId_productos();
    }

    @Override
    public List<productos> findAll(){
        List<productos> Listaproductos = (List<productos>) data.findAll();
        return Listaproductos;
    }

    @Override
    public List<productos> productosActivos() {
        List<productos> ListaProductosActivos = data.productosActivos("Habilitado");
        return ListaPacientesActivos
    }

    @Override
    public List<productos> filtroProductos(String filtro) {
        List<productos>Listaproductos=data.filtroProductos(filtro);
        return Listaproductos
    }

    @Override
    public Optional<productos> findOne(String id_productos) {
        Optional<productos> paciente=data.findById(id_productos);
        return productos;
    }

    @Override
    public int delete(String id_productos) {
        data.deleteBydId(id_productos);
        return 1;
    }
}