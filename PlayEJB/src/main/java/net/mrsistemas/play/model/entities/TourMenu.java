package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TOUR_MENU database table.
 * 
 */
@Entity
@Table(name="TOUR_MENU")
@NamedQuery(name="TourMenu.findAll", query="SELECT t FROM TourMenu t")
public class TourMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MENU")
	private long idMenu;

	private String codigo;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	private String nombre;

	@Column(name="ROL_ID")
	private String rolId;

	private String tipo;

	private String url;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TourMenu
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_SUBMENU")
	private TourMenu tourMenu;

	//bi-directional many-to-one association to TourMenu
	@OneToMany(mappedBy="tourMenu")
	private List<TourMenu> tourMenus;

	public TourMenu() {
	}

	public long getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(long idMenu) {
		this.idMenu = idMenu;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getRolId() {
		return this.rolId;
	}

	public void setRolId(String rolId) {
		this.rolId = rolId;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public TourMenu getTourMenu() {
		return this.tourMenu;
	}

	public void setTourMenu(TourMenu tourMenu) {
		this.tourMenu = tourMenu;
	}

	public List<TourMenu> getTourMenus() {
		return this.tourMenus;
	}

	public void setTourMenus(List<TourMenu> tourMenus) {
		this.tourMenus = tourMenus;
	}

	public TourMenu addTourMenus(TourMenu tourMenus) {
		getTourMenus().add(tourMenus);
		tourMenus.setTourMenu(this);

		return tourMenus;
	}

	public TourMenu removeTourMenus(TourMenu tourMenus) {
		getTourMenus().remove(tourMenus);
		tourMenus.setTourMenu(null);

		return tourMenus;
	}

}