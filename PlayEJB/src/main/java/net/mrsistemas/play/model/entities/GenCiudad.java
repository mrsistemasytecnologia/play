package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GEN_CIUDAD database table.
 * 
 */
@Entity
@Table(name="GEN_CIUDAD")
@NamedQueries({
	@NamedQuery(name="TourCiudad.findAll", query="SELECT t FROM GenCiudad t"),
	@NamedQuery(name="TourCiudad.findByCodigo", query="SELECT t FROM GenCiudad t where t.codCiudad = ?1"),
	@NamedQuery(name="TourCiudad.findByID", query="SELECT t FROM GenCiudad t where t.idCiudad = ?1"),
	@NamedQuery(name="TourCiudad.findByNombre", query="SELECT t FROM GenCiudad t where t.nombre like '%?1%'")
})
public class GenCiudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CIUDAD")
	private String idCiudad;

	@Column(name="COD_CIUDAD")
	private String codCiudad;

	private String descripcion;

	private String historia;

	private String latitud;

	private String longitud;

	private String nombre;

	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	//bi-directional many-to-one association to GenPais
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PAIS")
	private GenPais genPais;

	public GenCiudad() {}
	
	

	public GenCiudad(String idCiudad, String codCiudad, String descripcion, String historia, String latitud,
			String longitud, String nombre, String nombreCorto, GenPais genPais) {
		super();
		this.idCiudad = idCiudad;
		this.codCiudad = codCiudad;
		this.descripcion = descripcion;
		this.historia = historia;
		this.latitud = latitud;
		this.longitud = longitud;
		this.nombre = nombre;
		this.nombreCorto = nombreCorto;
		this.genPais = genPais;
	}



	public String getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getCodCiudad() {
		return this.codCiudad;
	}

	public void setCodCiudad(String codCiudad) {
		this.codCiudad = codCiudad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHistoria() {
		return this.historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public GenPais getGenPais() {
		return this.genPais;
	}

	public void setGenPais(GenPais genPais) {
		this.genPais = genPais;
	}

}