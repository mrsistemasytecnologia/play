package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TOUR_PARAMETROS database table.
 * 
 */
@Entity
@Table(name="TOUR_PARAMETROS")
@NamedQuery(name="TourParametro.findAll", query="SELECT t FROM TourParametro t")
public class TourParametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String aplicacion;

	private String descripcion;

	private String llave;

	private String observaciones;

	private String valor;

	public TourParametro() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAplicacion() {
		return this.aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLlave() {
		return this.llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}