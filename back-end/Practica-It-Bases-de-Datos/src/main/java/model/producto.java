package model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name="producto")
public class producto {
	
	public enum estado {
		Activo,
		Inactivo
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_producto", nullable = false, length = 36)
	private char id_producto;

	@Column(name = "nombre_producto", nullable = false, length = 45)
	private String nombre_producto;
	
	@Column(name = "descripcion", nullable = false, length = 45)
	private String descripcion;
	
	@Column(name = "cantidad", nullable = false, length = 100)
	private int cantidad;
	
	@Column(name = "precio", nullable = false, precision= 10, scale = 2)
	private BigDecimal precio;
	
	@Column(name = "porcentaje_iva", nullable = false, length = 2)
	private int porcentaje_iva;
	
	@Column(name = "porcentaje_descuento", nullable = false, length = 2)
	private int porcentaje_descuento;
	
	@Column(name = "estado", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private estado estado;

	public producto() {
		super();
	}

	public producto(char id_producto, String nombre_producto, String descripcion, int cantidad, BigDecimal precio,
			int porcentaje_iva, int porcentaje_descuento, model.producto.estado estado) {
		super();
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
		this.porcentaje_iva = porcentaje_iva;
		this.porcentaje_descuento = porcentaje_descuento;
		this.estado = estado;
	}

	public char getId_producto() {
		return id_producto;
	}

	public void setId_producto(char id_producto) {
		this.id_producto = id_producto;
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

	public int getPorcentaje_iva() {
		return porcentaje_iva;
	}

	public void setPorcentaje_iva(int porcentaje_iva) {
		this.porcentaje_iva = porcentaje_iva;
	}

	public int getPorcentaje_descuento() {
		return porcentaje_descuento;
	}

	public void setPorcentaje_descuento(int porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}

	public estado getEstado() {
		return estado;
	}

	public void setEstado(estado estado) {
		this.estado = estado;
	}
	
	

	
}
