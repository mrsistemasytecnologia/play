package net.mrsistemas.play.model.vo;

import java.io.Serializable;

public class CiudadVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String descripcion;
	private String nombre;
	private String nombreCorto;
	private String longitud;
	private String latitud;
	private String historia;
	private PaisVO genPais;

	public CiudadVO() {
		super();
	}
	
	public CiudadVO(String codVciudad, String vdescripcion, String vnombre, String vnombreCorto, String longitud,
			String latitud, PaisVO genPais) {
		super();
		this.id = codVciudad;
		this.descripcion = vdescripcion;
		this.nombre = vnombre;
		this.nombreCorto = vnombreCorto;
		this.longitud = longitud;
		this.latitud = latitud;
		this.genPais = genPais;
	}

	public String getCodVciudad() {
		return id;
	}

	public void setCodVciudad(String codVciudad) {
		this.id = codVciudad;
	}

	public String getVdescripcion() {
		return descripcion;
	}

	public void setVdescripcion(String vdescripcion) {
		this.descripcion = vdescripcion;
	}

	public String getVnombre() {
		return nombre;
	}

	public void setVnombre(String vnombre) {
		this.nombre = vnombre;
	}

	public String getVnombreCorto() {
		return nombreCorto;
	}

	public void setVnombreCorto(String vnombreCorto) {
		this.nombreCorto = vnombreCorto;
	}

	
	
	public String getLongitud() {
		return longitud;
	}


	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}


	public String getLatitud() {
		return latitud;
	}


	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public PaisVO getGenPais() {
		return genPais;
	}

	public void setGenPais(PaisVO genPais) {
		this.genPais = genPais;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CiudadVO [id=");
		builder.append(id);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", nombreCorto=");
		builder.append(nombreCorto);
		builder.append(", longitud=");
		builder.append(longitud);
		builder.append(", latitud=");
		builder.append(latitud);
		builder.append(", historia=");
		builder.append(historia);
		builder.append(", genPais=");
		builder.append(genPais);
		builder.append("]");
		return builder.toString();
	}

	

}
