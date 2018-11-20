package net.mrsistemas.play.model.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mrsistemas.play.model.dto.CityBeanController;

import net.mrsistemas.play.model.entities.GenCiudad;
import net.mrsistemas.play.model.vo.CiudadVO;
import net.mrsistemas.play.model.entities.GenPais;
import net.mrsistemas.play.model.vo.PaisVO;

import net.mrsistemas.play.model.vo.DatosUsuariosVO;

public class CiudadBO {
	private static final Logger log = LogManager.getLogger(UsuarioBO.class.getName());

	public CiudadBO() {
	}

	public CiudadVO persistCity(CiudadVO ciudad) throws Exception {
		try {
			GenCiudad genCiudad = (GenCiudad) CityBeanController.getInstance().setCityInDatabase(getEntityByCiudadVo(ciudad));
			return getCiudadVoByEntities(genCiudad);
		} catch (Exception e) {
			log.error("Se ha presentado un error con la consulta del usuario: [" + ciudad.getCodVciudad() + "] "
					+ e.getLocalizedMessage());
			throw new Exception(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<CiudadVO> getAllcities() {
		List<CiudadVO> list = new ArrayList<CiudadVO>();
		List<GenCiudad> lista = (List<GenCiudad>) CityBeanController.getInstance()
				.getAllCities("TourCiudad.findAll");
		for (GenCiudad genCiudad : lista) {
			list.add(getCiudadVoByEntities(genCiudad));
		}
		return list;
	}

	public CiudadVO getCityByCod(String codCiudad) throws Exception {
		try {
			return getCiudadVoByEntities((GenCiudad) CityBeanController.getInstance()
					.getCityByHql("TourCiudad.findByCodigo", codCiudad));
		} catch (Exception e) {
			log.error("Error logueando al usuario");
			throw new Exception(e);
		}

	}
	
	public CiudadVO getCityById(String codCiudad) throws Exception {
		try {
			return getCiudadVoByEntities((GenCiudad) CityBeanController.getInstance()
					.getCityByHql("TourCiudad.findByID", codCiudad));
		} catch (Exception e) {
			log.error("Error logueando al usuario");
			throw new Exception(e);
		}

	}
	
	public CiudadVO getCityByNombre(String nombre) throws Exception {
		try {
			return getCiudadVoByEntities((GenCiudad) CityBeanController.getInstance()
					.getCityByHql("TourCiudad.findByNombre", nombre));
		} catch (Exception e) {
			log.error("Error logueando al usuario");
			throw new Exception(e);
		}

	}
	
	public CiudadVO getCityByNombe(String codCiudad) throws Exception {
		try {
			return getCiudadVoByEntities((GenCiudad) CityBeanController.getInstance()
					.getCityByHql("TourCiudad.findByCodigo", codCiudad));
		} catch (Exception e) {
			log.error("Error logueando al usuario");
			throw new Exception(e);
		}

	}

	public CiudadVO getCitybyId(String id) {
		return  getCiudadVoByEntities((GenCiudad) CityBeanController.getInstance().getCityByHql("TourCiudad.findByID",id));
	}

	public DatosUsuariosVO updateUserbyId() {
		DatosUsuariosVO usuario = new DatosUsuariosVO();

		return usuario;
	}

	public DatosUsuariosVO updateUser() {
		DatosUsuariosVO usuario = new DatosUsuariosVO();

		return usuario;
	}

	/**
	 * <b> Cargar el VO desde los datos retornados por la entidad</b>
	 * 
	 * @param usuario
	 * @return
	 */
	private CiudadVO getCiudadVoByEntities(GenCiudad ciudad) {
		CiudadVO ciudadVo = new CiudadVO(ciudad.getCodCiudad(),ciudad.getDescripcion(),ciudad.getNombre(),ciudad.getNombreCorto(), ciudad.getLongitud(),ciudad.getLatitud(), null);
		return ciudadVo;
	}

	/**
	 * <b> Cargar la entidad desde los datos retornados por el VO</b>
	 * 
	 * @param usuario
	 * @return
	 */
	private GenCiudad getEntityByCiudadVo(CiudadVO ciudad) {
		GenCiudad genCiudad = new GenCiudad(null, ciudad.getCodVciudad(), ciudad.getVdescripcion(),
				ciudad.getHistoria(), ciudad.getLatitud(), ciudad.getLongitud(), ciudad.getVnombre(),
				ciudad.getVnombreCorto(), null);
		return genCiudad;
	}
	
	/**
	 * <b> Cargar el VO desde los datos retornados por la entidad</b>
	 * 
	 * @param usuario
	 * @return
	 */
	@SuppressWarnings("unused")
	private PaisVO getPaisVoByEntities(GenPais pais) {
		PaisVO paisVO = new PaisVO(pais.getIdVpais(),pais.getVcodigoCorto(),pais.getVcodigoPais(), pais.getVdescripcion(), pais.getVnombre());
		return paisVO;
	}

	/**
	 * <b> Cargar la entidad desde los datos retornados por el VO</b>
	 * 
	 * @param usuario
	 * @return
	 */
	@SuppressWarnings("unused")
	private GenPais getEntityByPaisVo(PaisVO pais) {
		GenPais genPais = new GenPais(pais.getIdVpais(), pais.getVcodigoCorto(), pais.getVcodigoPais(), pais.getVdescripcion(), pais.getVnombre());
		return genPais;
	}

}
