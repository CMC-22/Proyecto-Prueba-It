package com.example.Practica.It.Bases.de.Datos.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="productos")
public class productos {

@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "id_productos", nullable = false, length = 36) 
private char id_productos; 

@Column(name = "nombre_producto", nullable = false, length = 45) 
private String nombre_producto; 

@Column(name = "descripcion", nullable = false, length = 45) 
private String descripcion; 

@Column(name = "cantidad", nullable = false, length = 50) 
private int cantidad; 

@Column(name = "precio", nullable = false, length = 100) 
private BigDecimal precio; 

@Column(name = "porcentaje_iva", nullable = false, length = 2) 
private BigDecimal porcentaje_iva; 

@Column(name = "porcentaje_descuento", nullable = false, length = 2) 
private BigDecimal porcentaje_descuento;

@Column(name = "estado", nullable = false, length = 20) 
private String estado;


public productos() {
	super();
}



public productos(char id_productos, String nombre_producto, String descripcion, int cantidad, BigDecimal precio,
		BigDecimal porcentaje_iva, BigDecimal porcentaje_descuento, String estado) {
	super();
	this.id_productos = id_productos;
	this.nombre_producto = nombre_producto;
	this.descripcion = descripcion;
	this.cantidad = cantidad;
	this.precio = precio;
	this.porcentaje_iva = porcentaje_iva;
	this.porcentaje_descuento = porcentaje_descuento;
	this.estado = estado;
}

public char getId_productos() {
	return id_productos;
}

public void setId_productos(char id_productos) {
	this.id_productos = id_productos;
}

public String getNombre_producto() {
	return nombre_producto;
}

public void setNombre_producto(String nombre_producto) {
	this.nombre_producto = nombre_producto;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public BigDecimal getPrecio() {
	return precio;
}

public void setPrecio(BigDecimal precio) {
	this.precio = precio;
}

public BigDecimal getPorcentaje_iva() {
	return porcentaje_iva;
}

public void setPorcentaje_iva(BigDecimal porcentaje_iva) {
	this.porcentaje_iva = porcentaje_iva;
}

public BigDecimal getPorcentaje_desceunto() {
	return porcentaje_descuento;
}

public void setPorcentaje_descuento(BigDecimal porcentaje_descuento) {
	this.porcentaje_descuento = porcentaje_descuento;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
} 




}

