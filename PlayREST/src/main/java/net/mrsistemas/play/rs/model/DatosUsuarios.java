package net.mrsistemas.play.rs.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import net.mrsistemas.play.model.vo.DatosUsuariosVO;

@XmlRootElement(name="respuesta")
public class DatosUsuarios extends Respuesta {

	private static final long serialVersionUID = 1L;
	@XmlElement(name="lista")
	private Set<DatosUsuariosVO> listDatosUsuario = null;
	@XmlElement(name="datos")
	private DatosUsuariosVO datos = null;

	public DatosUsuarios() {}

	/**
	 * Método para la consulta de una operacion no exitosa.
	 * 
	 * @param iCodigo
	 * @param sestado
	 * @param smensaje
	 */
	public DatosUsuarios(int iCodigo, String sestado, String smensaje) {
		super(iCodigo, sestado, smensaje);
	}

	/**
	 * Contructor para una operacion de consulta exitosa.
	 * @param iCodigo
	 * @param sestado
	 * @param smensaje
	 * @param lista
	 */
	public DatosUsuarios(int iCodigo, String sestado, String smensaje, String auth, Set<DatosUsuariosVO> lista) {
		super(iCodigo, sestado, smensaje,auth);
		this.listDatosUsuario = lista;
	}

	/**
	 * Contructor para una operacion de consulta exitosa.
	 * 
	 * @param iCodigo
	 * @param sestado
	 * @param smensaje
	 * @param datosUsuario
	 */
	public DatosUsuarios(int iCodigo, String sestado, String smensaje, String auth, DatosUsuariosVO datosUsuario) {
		super(iCodigo, sestado, smensaje, auth);
		this.datos = datosUsuario;
	}

	public DatosUsuariosVO getDatos() {
		return datos;
	}

	public void setDatos(DatosUsuariosVO datosUsuario) {
		this.datos = datosUsuario;
	}

	/**
	 * @return the listDatosUsuario
	 */
	public Set<DatosUsuariosVO> getListDatosUsuario() {
		return listDatosUsuario;
	}

	/**
	 * @param listDatosUsuario the listDatosUsuario to set
	 */
	public void setListDatosUsuario(Set<DatosUsuariosVO> listDatosUsuario) {
		this.listDatosUsuario = listDatosUsuario;
	}
}
