package net.mrsistemas.play.model.vo;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PERFIL")
public class PerfilVO implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -1991060970671524296L;
	@XmlElement(name = "ID")
	private String idPerfil;
	@XmlElement(name = "DESCRIPCION")
	private String descripcion;
	@XmlElement(name = "NOMBRE")
	private String nombre;

	@XmlElement(name = "CATEGORIAS")
	private Set<CategoriaVO> tourCategorias;

	public PerfilVO() {
		// TODO Auto-generated constructor stub
	}

	public String getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<CategoriaVO> getTourCategorias() {
		return tourCategorias;
	}

	public void setTourCategorias(Set<CategoriaVO> tourCategorias) {
		this.tourCategorias = tourCategorias;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PerfilDTO [idPerfil=");
		builder.append(idPerfil);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", tourCategorias=");
		builder.append(tourCategorias);
		builder.append("]");
		return builder.toString();
	}

}
