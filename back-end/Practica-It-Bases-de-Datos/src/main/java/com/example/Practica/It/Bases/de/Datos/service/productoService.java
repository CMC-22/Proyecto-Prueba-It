package com.example.Practica.It.Bases.de.Datos.service;

import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Practica.It.Bases.de.Datos.interfaceService.IproductoService;
import com.example.Practica.It.Bases.de.Datos.interfaces.Iproductos;
import com.example.Practica.It.Bases.de.Datos.model.productos;

@Service
public class productoService implements IproductoService {
    @Autowired
    private Iproductos data;

    @Override
    public String save(productos productos) {
        Data.save(productos);
        return productos.getId_productos();
    }

    @Override
    public List<productos> findAll(){
        List<productos> Listaproductos = (List<productos>) data.findAll();
        return Listaproductos;
    }

    @Override
    public List<productos> productosActivos() {
        List<productos> ListaProductosActivos = Data.productosActivos("Habilitado");
        return ListaPacientesActivos
    }

    @Override
    public List<productos> filtroProductos(String filtro) {
        List<productos>Listaproductos=Data.filtroProductos(filtro);
        return Listaproductos
    }

    @Override
    public Optional<productos> findOne(String id_productos) {
        Optional<productos> productos=Data.findById(id_productos);
        return productos;
    }

    @Override
    public int delete(String id_productos) {
        data.deleteById(id_productos);
        return 1;
    }
}