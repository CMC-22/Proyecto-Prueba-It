package model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="venta")
public class venta {
	
	public enum estado {
		Activo,
		Inactivo
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_venta", nullable = false, length = 36)
	private char id_venta;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private  cliente cliente;
	
	@Column(name = "total", nullable = false, length = 2)
	private String total;
	
	@Column(name = "estado", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private estado estado;
	
	@Column(name = "fecha_venta", nullable = false, length = 50)
	private LocalDate fecha_venta;

	public venta() {
		super();
	}

	public venta(char id_venta, model.cliente cliente, String total, model.venta.estado estado, LocalDate fecha_venta) {
		super();
		this.id_venta = id_venta;
		this.cliente = cliente;
		this.total = total;
		this.estado = estado;
		this.fecha_venta = fecha_venta;
	}

	public char getId_venta() {
		return id_venta;
	}

	public void setId_venta(char id_venta) {
		this.id_venta = id_venta;
	}

	public cliente getCliente() {
		return cliente;
	}

	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public estado getEstado() {
		return estado;
	}

	public void setEstado(estado estado) {
		this.estado = estado;
	}

	public LocalDate getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(LocalDate fecha_venta) {
		this.fecha_venta = fecha_venta;
	}
	
	

	
	

}
