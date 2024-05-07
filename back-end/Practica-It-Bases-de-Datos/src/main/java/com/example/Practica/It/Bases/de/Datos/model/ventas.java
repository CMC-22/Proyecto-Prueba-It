package com.example.Practica.It.Bases.de.Datos.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="ventas")
public class ventas {

@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "id_ventas", nullable = false, length = 36) 
private char id_ventas; 


@ManyToOne
@JoinColumn(name="id_clientes")
private clientes clientes;




@Column(name = "total", nullable = false, length = 45) 
private String total; 

@Column(name = "estado", nullable = false, length = 45) 
private Enum estado; 

@Column(name = "fecha_venta", nullable = false, length = 50) 
private Date fecha_venta;

public ventas() {
	super();
}

public ventas(char id_ventas, String total, Enum estado, Date fecha_venta) {
	super();
	this.id_ventas = id_ventas;
	this.total = total;
	this.estado = estado;
	this.fecha_venta = fecha_venta;
}

public char getId_ventas() {
	return id_ventas;
}

public void setId_ventas(char id_ventas) {
	this.id_ventas = id_ventas;
}

public String getTotal() {
	return total;
}

public void setTotal(String total) {
	this.total = total;
}

public Enum getEstado() {
	return estado;
}

public void setEstado(Enum estado) {
	this.estado = estado;
}

public Date getFecha_venta() {
	return fecha_venta;
}

public void setFecha_venta(Date fecha_venta) {
	this.fecha_venta = fecha_venta;
} 



}