package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the TOUR_DATOS_USUARIO database table.
 * 
 */ 
@Entity
@Table(name = "TOUR_DATOS_USUARIO")
@NamedQueries({ @NamedQuery(name = "TourDatosUsuario.findAll", query = "select o from TourDatosUsuario o"),
		@NamedQuery(name = "TourDatosUsuario.findByDni", query = "select o from TourDatosUsuario o where o.dni = ?1"),
		@NamedQuery(name = "TourDatosUsuario.findById", query = "select o from TourDatosUsuario o where o.usuarioId = ?1") })
public class TourDatosUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USUARIO_ID")
	private String usuarioId;

	private String apellidos;

	private String ciudad;

	private String direccion;

	private String dni;

	private String email;

	private String movil;

	private String nombres;

	private String pais;

	@Column(name = "TEL_PRINCIPAL")
	private String telPrincipal;

	// bi-directional many-to-one association to TourRolesUsuario
	@OneToMany(mappedBy = "tourDatosUsuario")
	private List<TourRolesUsuario> tourRolesUsuarios;

	public TourDatosUsuario() {
	}

	/**
	 * <b>Constructor con parametros, la funcion priencipal es cargar los datos
	 * des la entidad persistente.</b>
	 * 
	 * @param usuarioId
	 * @param apellidos
	 * @param ciudad
	 * @param direccion
	 * @param dni
	 * @param email
	 * @param movil
	 * @param nombres
	 * @param pais
	 * @param telPrincipal
	 * @param tourRolesUsuarios
	 */
	public TourDatosUsuario(String usuarioId, String apellidos, String ciudad, String direccion, String dni,
			String email, String movil, String nombres, String pais, String telPrincipal,
			List<TourRolesUsuario> tourRolesUsuarios) {
		super();
		this.usuarioId = usuarioId;
		this.apellidos = apellidos;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.dni = dni;
		this.email = email;
		this.movil = movil;
		this.nombres = nombres;
		this.pais = pais;
		this.telPrincipal = telPrincipal;
		this.tourRolesUsuarios = tourRolesUsuarios;
	}

	/**
	 * <b>Constructor con parametros para cargar datos desde el objeto VO.</b>
	 * 
	 * @param apellidos
	 * @param ciudad
	 * @param direccion
	 * @param dni
	 * @param email
	 * @param movil
	 * @param nombres
	 * @param pais
	 * @param telPrincipal
	 */
	public TourDatosUsuario(String apellidos, String ciudad, String direccion, String dni, String email, String movil,
			String nombres, String pais, String telPrincipal) {
		super();
		this.apellidos = apellidos;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.dni = dni;
		this.email = email;
		this.movil = movil;
		this.nombres = nombres;
		this.pais = pais; 
		this.telPrincipal = telPrincipal;
		//this.tourRolesUsuarios = tourRolesUsuarios;
	}

	public String getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMovil() {
		return this.movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelPrincipal() {
		return this.telPrincipal;
	}

	public void setTelPrincipal(String telPrincipal) {
		this.telPrincipal = telPrincipal;
	}

	public List<TourRolesUsuario> getTourRolesUsuarios() {
		return this.tourRolesUsuarios;
	}

	public void setTourRolesUsuarios(List<TourRolesUsuario> tourRolesUsuarios) {
		this.tourRolesUsuarios = tourRolesUsuarios;
	}

	public TourRolesUsuario addTourRolesUsuario(TourRolesUsuario tourRolesUsuario) {
		getTourRolesUsuarios().add(tourRolesUsuario);
		tourRolesUsuario.setTourDatosUsuario(this);

		return tourRolesUsuario;
	}

	public TourRolesUsuario removeTourRolesUsuario(TourRolesUsuario tourRolesUsuario) {
		getTourRolesUsuarios().remove(tourRolesUsuario);
		tourRolesUsuario.setTourDatosUsuario(null);

		return tourRolesUsuario;
	}

}