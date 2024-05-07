package com.example.Practica.It.Bases.de.Datos.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name="clientes")
public class clientes {

@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "id_clientes", nullable = false, length = 36) 
private char id_clientes; 

@Column(name = "tipo_documento", nullable = false, length = 2) 
private Enum tipo_documento; 

@Column(name = "numero_documento", nullable = false, length = 10) 
private String numero_documento; 

@Column(name = "nombre_cliente", nullable = false, length = 45) 
private String nombre_cliente;

@Column(name = "apellido_cliente", nullable = false, length = 45) 
private String apellido_cliente;

@Column(name = "telefono", nullable = false, length = 13) 
private String telefono;

@Column(name = "direccion", nullable = false, length = 45) 
private String dirreccion;

@Column(name = "ciudad", nullable = false, length = 45) 
private String ciudad;

@Column(name = "estado", nullable = false, length = 20) 
private Enum estado;


}

