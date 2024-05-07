package com.example.Practica.It.Bases.de.Datos.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.Practica.It.Bases.de.Datos.model.productos;

public interface IproductoService{
    public char save (productos productos);
    public List<productos>findAll();
    public List<productos>productosActivos();
    public Optional<productos>findOne(char id_productos);
    public int delete(char id_productos);
    List<productos>filtroProductos(String filtro);
    
}