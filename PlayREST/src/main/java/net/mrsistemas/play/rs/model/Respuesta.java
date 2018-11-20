package net.mrsistemas.play.rs.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <b>Esta instancia contiene los datos genericos de toda respuesta mensaje.</b>
 * 
 * @author maxther
 * @Return Codigo: 0 = Error, 1 = Exitoso;
 *
 */
@XmlRootElement(name="respuesta")
public class Respuesta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3728380322245259164L;
	@XmlElement(name="codigo")
	private int iCodigo = -1;
	@XmlElement(name="estado")
	private String sestado = "";
	@XmlElement(name="mensaje")
	private String smensaje = "";
	@XmlElement(name="autentication")
	private String auth    = "";

	
	public Respuesta() {
		super();
	}

	/**
	 * Constructor con los valores de retorno de una respuesta generica.
	 * 
	 * @param iCodigo
	 * @param sestado
	 * @param smensaje
	 */
	public Respuesta(int iCodigo, String sestado, String smensaje) {
		this.iCodigo = iCodigo;
		this.sestado = sestado;
		this.smensaje = smensaje;
	}
	
	public Respuesta(int iCodigo, String sestado, String smensaje, String auth) {
		super();
		this.iCodigo = iCodigo;
		this.sestado = sestado;
		this.smensaje = smensaje;
		this.auth = auth;
	}

	public int getiCodigo() {
		return iCodigo;
	}

	public void setiCodigo(int iCodigo) {
		this.iCodigo = iCodigo;
	}

	public String getSmensaje() {
		return smensaje;
	}

	public void setSmensaje(String smensaje) {
		this.smensaje = smensaje;
	}

	public String getSestado() {
		return sestado;
	}

	public void setSestado(String sestado) {
		this.sestado = sestado;
	}
	
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Respuesta [iCodigo=");
		builder.append(iCodigo);
		builder.append(", sestado=");
		builder.append(sestado);
		builder.append(", smensaje=");
		builder.append(smensaje);
		builder.append(", auth=");
		builder.append(auth);
		builder.append("]");
		return builder.toString();
	}
}
