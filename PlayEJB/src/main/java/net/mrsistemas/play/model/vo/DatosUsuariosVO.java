package net.mrsistemas.play.model.vo;

import java.io.Serializable;

public class DatosUsuariosVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dni;
	private String nombres;
	private String apellidos;
	private String ciudad;
	private String direccion;
	private String email;
	private String movil;
	private String pais;

	public DatosUsuariosVO() {
		super();
	}

	public DatosUsuariosVO(String dni, String nombres, String apellidos, String ciudad, String direccion, String email,
			String movil, String pais) {
		super();
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.email = email;
		this.movil = movil;
		this.pais = pais;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
