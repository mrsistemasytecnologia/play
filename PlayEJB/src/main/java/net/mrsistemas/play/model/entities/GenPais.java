package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the GEN_PAISES database table.
 * 
 */
@Entity
@Table(name = "GEN_PAISES")
@NamedQueries({ @NamedQuery(name = "GenPais.findAll", query = "SELECT t FROM GenPais t"),
		@NamedQuery(name = "GenPais.findById", query = "SELECT t FROM GenPais t where t.vcodigoCorto = ?1") })
public class GenPais implements Serializable {
	private static final long serialVersionUID = 1L;
	
	

	@Id
	@Column(name = "ID_VPAIS")
	private long idVpais;

	@Column(name = "VCODIGO_CORTO")
	private String vcodigoCorto;

	@Column(name = "VCODIGO_PAIS")
	private String vcodigoPais;
	private String vdescripcion;
	private String vnombre;

	// bi-directional many-to-one association to GenCiudad
	@OneToMany(mappedBy = "genPais")
	private List<GenCiudad> genCiudads;

	public GenPais() {
	}
	
	public GenPais(long idVpais, String vcodigoCorto, String vcodigoPais, String vdescripcion, String vnombre) {
		super();
		this.idVpais = idVpais;
		this.vcodigoCorto = vcodigoCorto;
		this.vcodigoPais = vcodigoPais;
		this.vdescripcion = vdescripcion;
		this.vnombre = vnombre;
	}



	public long getIdVpais() {
		return this.idVpais;
	}

	public void setIdVpais(long idVpais) {
		this.idVpais = idVpais;
	}

	public String getVcodigoCorto() {
		return this.vcodigoCorto;
	}

	public void setVcodigoCorto(String vcodigoCorto) {
		this.vcodigoCorto = vcodigoCorto;
	}

	public String getVcodigoPais() {
		return this.vcodigoPais;
	}

	public void setVcodigoPais(String vcodigoPais) {
		this.vcodigoPais = vcodigoPais;
	}

	public String getVdescripcion() {
		return this.vdescripcion;
	}

	public void setVdescripcion(String vdescripcion) {
		this.vdescripcion = vdescripcion;
	}

	public String getVnombre() {
		return this.vnombre;
	}

	public void setVnombre(String vnombre) {
		this.vnombre = vnombre;
	}

	public List<GenCiudad> getGenCiudads() {
		return this.genCiudads;
	}

	public void setGenCiudads(List<GenCiudad> genCiudads) {
		this.genCiudads = genCiudads;
	}

	public GenCiudad addGenCiudad(GenCiudad genCiudad) {
		getGenCiudads().add(genCiudad);
		genCiudad.setGenPais(this);

		return genCiudad;
	}

	public GenCiudad removeGenCiudad(GenCiudad genCiudad) {
		getGenCiudads().remove(genCiudad);
		genCiudad.setGenPais(null);

		return genCiudad;
	}

}