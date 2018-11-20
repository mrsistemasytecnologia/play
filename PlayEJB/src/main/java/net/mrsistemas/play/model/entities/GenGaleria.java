package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GEN_GALERIA database table.
 * 
 */
@Entity
@Table(name="GEN_GALERIA")
@NamedQuery(name="GenGaleria.findAll", query="SELECT g FROM GenGaleria g")
public class GenGaleria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_IMG")
	private String idImg;

	@Column(name="COD_CIUDAD")
	private String codCiudad;

	@Column(name="TIPO_IMAGEN")
	private String tipoImagen;

	@Column(name="URL_IMG")
	private String urlImg;

	public GenGaleria() {
	}

	public String getIdImg() {
		return this.idImg;
	}

	public void setIdImg(String idImg) {
		this.idImg = idImg;
	}

	public String getCodCiudad() {
		return this.codCiudad;
	}

	public void setCodCiudad(String codCiudad) {
		this.codCiudad = codCiudad;
	}

	public String getTipoImagen() {
		return this.tipoImagen;
	}

	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
	}

	public String getUrlImg() {
		return this.urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

}