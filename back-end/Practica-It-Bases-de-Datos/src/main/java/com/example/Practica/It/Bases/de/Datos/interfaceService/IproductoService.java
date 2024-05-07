package com.example.Practica.It.Bases.de.Datos.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.Practica.It.Bases.de.Datos.model.productos;

public interface IproductoService{
    public String save (productos productos);
    public List<productos>findAll();
    public List<productos>productosActivos();
    public Optional<productos>findOne(String id_productos);
    public int delete(String id_productos);
    List<productos>filtroProductos(String filtro);
    
}