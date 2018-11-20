package net.mrsistemas.play.model.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class PaisVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3552565020368152268L;
	
	@XmlElement(name = "IDPAIS")
	private long idVpais;
	@XmlElement(name = "CODIGOCORTO")
	private String vcodigoCorto;
	@XmlElement(name = "CODIGO")
	private String vcodigoPais;
	@XmlElement(name = "DESCRIPCION")
	private String vdescripcion;
	@XmlElement(name = "NOMBRE")
	private String vnombre;

	public PaisVO() {
		super();
	}

	/**
	 * <b>Constructor de pais con parametros.</b>
	 * @param idVpais
	 * @param vcodigoCorto
	 * @param vcodigoPais
	 * @param vdescripcion
	 * @param vnombre
	 */
	public PaisVO(long idVpais, String vcodigoCorto, String vcodigoPais, String vdescripcion, String vnombre) {
		super();
		this.idVpais = idVpais;
		this.vcodigoCorto = vcodigoCorto;
		this.vcodigoPais = vcodigoPais;
		this.vdescripcion = vdescripcion;
		this.vnombre = vnombre;
	}

	public long getIdVpais() {
		return idVpais;
	}

	public void setIdVpais(long idVpais) {
		this.idVpais = idVpais;
	}

	public String getVcodigoCorto() {
		return vcodigoCorto;
	}

	public void setVcodigoCorto(String vcodigoCorto) {
		this.vcodigoCorto = vcodigoCorto;
	}

	public String getVcodigoPais() {
		return vcodigoPais;
	}

	public void setVcodigoPais(String vcodigoPais) {
		this.vcodigoPais = vcodigoPais;
	}

	public String getVdescripcion() {
		return vdescripcion;
	}

	public void setVdescripcion(String vdescripcion) {
		this.vdescripcion = vdescripcion;
	}

	public String getVnombre() {
		return vnombre;
	}

	public void setVnombre(String vnombre) {
		this.vnombre = vnombre;
	}

	@Override
	public String toString() {
		return "PaisDTO [idVpais=" + idVpais + ", vcodigoCorto=" + vcodigoCorto + ", vcodigoPais=" + vcodigoPais
				+ ", vdescripcion=" + vdescripcion + ", vnombre=" + vnombre + "]";
	}
	


}
