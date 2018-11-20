package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TOUR_ROLES database table.
 * 
 */
@Entity
@Table(name="TOUR_ROLES")
@NamedQuery(name="TourRole.findAll", query="SELECT t FROM TourRole t")
public class TourRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROL_ID")
	private String rolId;

	private String codigo;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	private String nombre;

	private String usuario;

	//bi-directional many-to-one association to TourRolesUsuario
	@OneToMany(mappedBy="tourRole")
	private List<TourRolesUsuario> tourRolesUsuarios;

	public TourRole() {
	}

	public String getRolId() {
		return this.rolId;
	}

	public void setRolId(String rolId) {
		this.rolId = rolId;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<TourRolesUsuario> getTourRolesUsuarios() {
		return this.tourRolesUsuarios;
	}

	public void setTourRolesUsuarios(List<TourRolesUsuario> tourRolesUsuarios) {
		this.tourRolesUsuarios = tourRolesUsuarios;
	}

	public TourRolesUsuario addTourRolesUsuario(TourRolesUsuario tourRolesUsuario) {
		getTourRolesUsuarios().add(tourRolesUsuario);
		tourRolesUsuario.setTourRole(this);

		return tourRolesUsuario;
	}

	public TourRolesUsuario removeTourRolesUsuario(TourRolesUsuario tourRolesUsuario) {
		getTourRolesUsuarios().remove(tourRolesUsuario);
		tourRolesUsuario.setTourRole(null);

		return tourRolesUsuario;
	}

}