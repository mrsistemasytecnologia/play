package net.mrsistemas.play.rs.model;

import java.util.List;

import net.mrsistemas.play.model.vo.CiudadVO;


public class Ciudad extends Respuesta {

	private static final long serialVersionUID = 2203683384554602382L;
	private List<CiudadVO> listCities = null;
	private CiudadVO datos = null;

	public Ciudad() {}

	/**
	 * Método para la consulta de una operacion no exitosa.
	 * 
	 * @param iCodigo
	 * @param sestado
	 * @param smensaje
	 */
	
	public Ciudad(int iCodigo, String sestado, String smensaje) {
		super(iCodigo, sestado, smensaje);
	}


	/**
	 * Constructor para una operacion de consulta exitosa, con un listado de ciudades.
	 * 
	 * @param iCodigo
	 * @param sestado
	 * @param smensaje
	 * @param lista
	 */
	public Ciudad(int iCodigo, String sestado, String smensaje, String auth, List<CiudadVO> lista) {
		super(iCodigo, sestado, smensaje);
		this.listCities = lista;
	}

	/**
	 * Constructor para una operacion de consulta exitosa, retornando una sola ciudad
	 * 
	 * @param iCodigo
	 * @param sestado
	 * @param smensaje
	 * @param datosUsuario
	 */
	public Ciudad(int iCodigo, String sestado, String smensaje, String auth, CiudadVO datos) {
		super(iCodigo, sestado, smensaje, auth);
		this.datos = datos;
	}
	
	

	public CiudadVO getDatos() {
		return datos;
	}

	public void setDatos(CiudadVO datos) {
		this.datos = datos;
	}

	public List<CiudadVO> getListCities() {
		return listCities;
	}

	public void setListDatosUsuario(List<CiudadVO> listCities) {
		this.listCities = listCities;
	}


}
