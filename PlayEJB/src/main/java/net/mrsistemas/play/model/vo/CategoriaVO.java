package net.mrsistemas.play.model.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CATEGORIA")
public class CategoriaVO implements Serializable {
	/**
	 * <b>UID</b>
	 */
	private static final long serialVersionUID = 7982289016659224410L;

	@XmlElement(name = "ID")
	private String idCategoria;

	@XmlElement(name="COD_DESTINO")
	private String codDestino;
	
	@XmlElement(name="PORCENTAJE")
	private String porcentajeAjuste;
	
	@XmlElement(name="COD_PERFIL")
	private String codPerfil;

	@XmlElement(name="PERFIL")
	private PerfilVO genPerfil;

	public CategoriaVO() {
		// TODO Auto-generated constructor stub
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCodDestino() {
		return codDestino;
	}

	public void setCodDestino(String codDestino) {
		this.codDestino = codDestino;
	}

	public String getPorcentajeAjuste() {
		return porcentajeAjuste;
	}

	public void setPorcentajeAjuste(String porcentajeAjuste) {
		this.porcentajeAjuste = porcentajeAjuste;
	}

	public PerfilVO getGenPerfil() {
		return genPerfil;
	}

	public void setGenPerfil(PerfilVO genPerfil) {
		this.genPerfil = genPerfil;
	}

	public String getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoriaDTO [idCategoria=");
		builder.append(idCategoria);
		builder.append(", codDestino=");
		builder.append(codDestino);
		builder.append(", porcentajeAjuste=");
		builder.append(porcentajeAjuste);
		builder.append(", codPerfil=");
		builder.append(codPerfil);
		builder.append(", genPerfil=");
		builder.append(genPerfil);
		builder.append("]");
		return builder.toString();
	}

	

}
