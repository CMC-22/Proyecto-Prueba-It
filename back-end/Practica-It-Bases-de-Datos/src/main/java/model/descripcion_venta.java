package model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="descripcion_venta")
public class descripcion_venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_descripcion_venta", nullable = false, length = 36)
	private String id_descripcion_venta;
	
	
	@ManyToOne
	@JoinColumn(name="id_venta")
	private venta venta;
	
	@ManyToOne
	@JoinColumn(name="id_producto")
	private producto producto;

	@Column(name = "cantidad", nullable = false, length = 100)
	private String cantidad;
	
	@Column(name = "precio", nullable = false, precision= 10, scale = 2)
	private BigDecimal precio;
	
	@Column(name = "descuento", nullable = false, precision= 10, scale = 2)
	private BigDecimal descuento;
	
	@Column(name = "sub_total", nullable = false, precision= 10, scale = 2)
	private BigDecimal sub_total;

	public descripcion_venta() {
		super();
	}

	public descripcion_venta(String id_descripcion_venta, model.venta venta, model.producto producto, String cantidad,
			BigDecimal precio, BigDecimal descuento, BigDecimal sub_total) {
		super();
		this.id_descripcion_venta = id_descripcion_venta;
		this.venta = venta;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.descuento = descuento;
		this.sub_total = sub_total;
	}

	public String getId_descripcion_venta() {
		return id_descripcion_venta;
	}

	public void setId_descripcion_venta(String id_descripcion_venta) {
		this.id_descripcion_venta = id_descripcion_venta;
	}

	public venta getVenta() {
		return venta;
	}

	public void setVenta(venta venta) {
		this.venta = venta;
	}

	public producto getProducto() {
		return producto;
	}

	public void setProducto(producto producto) {
		this.producto = producto;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
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
