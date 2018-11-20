package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the TOUR_USUARIOS database table.
 * 
 */
@Entity
@Table(name = "TOUR_USUARIOS")
@NamedQueries({ @NamedQuery(name = "TourUsuarios.findAll", query = "select o from TourUsuario o"),
		@NamedQuery(name = "TourUsuarios.findByLogged", query = "select o from TourUsuario o where o.usuario = ?1 and o.passwd = ?2"),

})
public class TourUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USUARIO_ID")
	private String usuarioId;

	private String passwd;

	private String usuario;

	public TourUsuario() {
	}

	public TourUsuario(String usuarioId, String passwd, String usuario) {
		super();
		this.usuarioId = usuarioId;
		this.passwd = passwd;
		this.usuario = usuario;
	}

	public String getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}