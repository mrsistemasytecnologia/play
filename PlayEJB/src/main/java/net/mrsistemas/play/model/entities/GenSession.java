package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GEN_SESSIONS database table.
 * 
 */
@Entity
@Table(name="GEN_SESSIONS")
@NamedQueries({
	@NamedQuery(name="GenSession.findAll", query="SELECT g FROM GenSession g"),
	@NamedQuery(name="GenSession.findBySession", query="SELECT g FROM GenSession g where g.idUsuario = ?1 and g.host = ?2"),
	@NamedQuery(name="GenSession.findByIdSession", query="SELECT g FROM GenSession g where g.idSesion = ?1")
})

public class GenSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SESION")
	private String idSesion;

	@Column(name="FECHA_FIN")
	private String fechaFin;

	@Column(name="FECHA_INICIO")
	private String fechaInicio;

	@Column(name="\"HOST\"")
	private String host;

	@Column(name="ID_USUARIO")
	private String idUsuario;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	public GenSession() {
	}

	public String getIdSesion() {
		return this.idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}

	public String getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

}