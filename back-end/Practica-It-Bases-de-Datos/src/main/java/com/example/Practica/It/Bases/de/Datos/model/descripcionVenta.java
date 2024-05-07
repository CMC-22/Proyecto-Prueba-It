package com.example.Practica.It.Bases.de.Datos.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="descripcionVenta")
public class descripcionVenta {

   
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_descripcionVenta", nullable = false, length = 36)
    private char id_descripcionVenta;
	
	@ManyToOne
	@JoinColumn(name="id_ventas")
	private ventas ventas;
	
	@ManyToOne
	@JoinColumn(name="id_productos")
	private productos productos;

    @Column(name = "cantidad", nullable = false, length = 50)
    private int cantidad;

    @Column(name = "precio", nullable = false, length = 50)
    private BigDecimal precio;

    @Column(name = "descuento", nullable = false, length = 50)
    private BigDecimal descuento;

    @Column(name = "sub_total", nullable = false, length = 50)
    private BigDecimal sub_total;

	public descripcionVenta() {
		super();
	}

	public descripcionVenta(char id_descripcionVenta, com.example.Practica.It.Bases.de.Datos.model.ventas ventas,
			com.example.Practica.It.Bases.de.Datos.model.productos productos, int cantidad, BigDecimal precio,
			BigDecimal descuento, BigDecimal sub_total) {
		super();
		this.id_descripcionVenta = id_descripcionVenta;
		this.ventas = ventas;
		this.productos = productos;
		this.cantidad = cantidad;
		this.precio = precio;
		this.descuento = descuento;
		this.sub_total = sub_total;
	}

	public char getId_descripcionVenta() {
		return id_descripcionVenta;
	}

	public void setId_descripcionVenta(char id_descripcionVenta) {
		this.id_descripcionVenta = id_descripcionVenta;
	}

	public ventas getVentas() {
		return ventas;
	}

	public void setVentas(ventas ventas) {
		this.ventas = ventas;
	}

	public productos getProductos() {
		return productos;
	}

	public void setProductos(productos productos) {
		this.productos = productos;
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

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getSub_total() {
		return sub_total;
	}

	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}
    
    
	

    

    

}