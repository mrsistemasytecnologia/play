package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TOUR_ROLES_USUARIO database table.
 * 
 */
@Entity
@Table(name="TOUR_ROLES_USUARIO")
@NamedQuery(name="TourRolesUsuario.findAll", query="SELECT t FROM TourRolesUsuario t")
public class TourRolesUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USROL_ID")
	private String usrolId;

	//bi-directional many-to-one association to TourDatosUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USUARIO_ID")
	private TourDatosUsuario tourDatosUsuario;

	//bi-directional many-to-one association to TourRole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ROL_ID")
	private TourRole tourRole;

	public TourRolesUsuario() {
	}

	public String getUsrolId() {
		return this.usrolId;
	}

	public void setUsrolId(String usrolId) {
		this.usrolId = usrolId;
	}

	public TourDatosUsuario getTourDatosUsuario() {
		return this.tourDatosUsuario;
	}

	public void setTourDatosUsuario(TourDatosUsuario tourDatosUsuario) {
		this.tourDatosUsuario = tourDatosUsuario;
	}

	public TourRole getTourRole() {
		return this.tourRole;
	}

	public void setTourRole(TourRole tourRole) {
		this.tourRole = tourRole;
	}

}