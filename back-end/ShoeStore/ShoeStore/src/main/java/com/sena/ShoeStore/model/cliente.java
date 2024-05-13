package com.sena.ShoeStore.model;

import com.example.demo.exepcion.ErrorExcepcion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="cliente")
public class cliente {
	
	public enum estadoCliente {
		ACTIVO,
		INACTIVO
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cliente", nullable = false, length = 36)
	private String id_cliente;
	
	@Column(name = "tipo_documento", nullable = false, length = 2)
	private String tipo_documento;
	
	@Column(name = "numero_documento", nullable = false, length = 10)
	private String numero_documento;
	
	@Column(name = "nombre_cliente", nullable = false, length = 45)
	private String nombre_cliente;
	
	@Column(name = "apellido_cliente", nullable = false, length = 45)
	private String apellido_cliente;
	
	@Column(name = "telefono", nullable = false, length = 13)
	private String telefono;
	
	@Column(name = "direccion", nullable = false, length = 45)
	private String direccion;
	
	@Column(name = "ciudad", nullable = false, length = 45)
	private String ciudad;
	
	@Column(name = "correo", nullable = false, length = 100)
	private String correo;
	
	@Column(name = "estado", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private estadoCliente estado;

	
	
	public void crearCliente() {
	    if (tipo_documento.length() < 2) {
	        throw new ErrorExcepcion("El campo tipo de identificación no debe estar vacío");
	    }
	    if (numero_documento == null || numero_documento.length() < 5 || numero_documento.length() > 11){
			throw new ErrorExcepcion("El campo numero de documento debe tener de 5 a 11 caracteres");
	    }
	    if (nombre_cliente == null || nombre_cliente.length() < 3 || nombre_cliente.length() > 30) {
	        throw new ErrorExcepcion("El campo nombre cliente debe tener de 3 a 30 caracteres");
	    }
	    if (apellido_cliente == null || apellido_cliente.length() < 3 || apellido_cliente.length() > 30) {
	        throw new ErrorExcepcion("El campo apellido cliente debe tener de 3 a 30 caracteres");
	    }
	    if (telefono == null || telefono.length() != 10) {
	        throw new ErrorExcepcion("El campo teléfono debe tener 10 caracteres");
	    }
	    if (estado == null) {
	        throw new ErrorExcepcion("El campo estado no debe ser nulo");
	    }
	}
	
	
	public cliente() {
		super();
	}

	public cliente(String id_cliente, String tipo_documento, String numero_documento, String nombre_cliente,
			String apellido_cliente, String telefono, String direccion, String ciudad, String correo,
			estadoCliente estado) {
		super();
		this.id_cliente = id_cliente;
		this.tipo_documento = tipo_documento;
		this.numero_documento = numero_documento;
		this.nombre_cliente = nombre_cliente;
		this.apellido_cliente = apellido_cliente;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.correo = correo;
		this.estado = estado;
	}

	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getApellido_cliente() {
		return apellido_cliente;
	}

	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public estadoCliente getEstado() {
		return estado;
	}

	public void setEstado(estadoCliente estado) {
		this.estado = estado;
	}
}
