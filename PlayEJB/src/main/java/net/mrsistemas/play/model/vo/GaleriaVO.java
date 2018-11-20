package net.mrsistemas.play.model.vo;

import javax.xml.bind.annotation.XmlElement;

public class GaleriaVO {

	@XmlElement(name = "DESCRIPCION")
	private String descripcion;

	@XmlElement(name = "NOMBRE")
	private String nombre;

	@XmlElement(name = "URL")
	private String url;

	public GaleriaVO() {
		super();
	}
	
	public GaleriaVO(String descripcion, String nombre, String url) {
		super();
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

}
