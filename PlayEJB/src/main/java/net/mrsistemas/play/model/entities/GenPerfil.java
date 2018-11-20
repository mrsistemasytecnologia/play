package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GEN_PERFIL database table.
 * 
 */
@Entity
@Table(name="GEN_PERFIL")
@NamedQuery(name="GenPerfil.findAll", query="SELECT g FROM GenPerfil g")
public class GenPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PERFIL")
	private String idPerfil;

	@Column(name="COD_PERFIL")
	private String codPerfil;

	private String descripcion;

	private String nombre;

	public GenPerfil() {
	}

	public String getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getCodPerfil() {
		return this.codPerfil;
	}

	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}