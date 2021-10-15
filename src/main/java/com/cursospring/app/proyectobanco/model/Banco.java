package com.cursospring.app.proyectobanco.model;

public class Banco {
	private String ciudad;
	private String estado;
	private String direccion;
	private String tipo;
	private String codigoPostal;
	
	
	
	public Banco(String ciudad, String estado, String direccion, String tipo, String codigoPostal) {
		this.ciudad = ciudad;
		this.estado = estado;
		this.direccion = direccion;
		this.tipo = tipo;
		this.codigoPostal = codigoPostal;
	}
	
	public Banco() {

	}

	
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "Sucursal [ciudad=" + ciudad + ", estado=" + estado + ", direccion=" + direccion + ", tipo=" + tipo
				+ ", codigoPostal=" + codigoPostal + "]";
	}
}
