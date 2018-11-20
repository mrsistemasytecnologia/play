package net.mrsistemas.play.model.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mrsistemas.play.model.dto.UserBeanController;
import net.mrsistemas.play.model.entities.TourDatosUsuario;
import net.mrsistemas.play.model.vo.DatosUsuariosVO;

public class DatosUsuarioBO {
	private static final Logger log = LogManager.getLogger(UsuarioBO.class.getName());

	public DatosUsuarioBO() {
	}

	public DatosUsuariosVO persistUser(DatosUsuariosVO datosUsuario) throws Exception {
		try {
			TourDatosUsuario usr = (TourDatosUsuario) UserBeanController.getInstance()
					.persistEntity(getEntityByUserVo(datosUsuario));
			if (usr != null) {
				datosUsuario = getUserVoByEntities(usr);
			} else {
				log.error("El usuario no existe: " + datosUsuario.getDni());
			}
			return datosUsuario;
		} catch (Exception e) {
			log.error("Se ha presentado un error con la consulta del usuario: [" + datosUsuario.getDni() + "] "
					+ e.getLocalizedMessage());
			throw new Exception(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<DatosUsuariosVO> getAllUser() {
		List<DatosUsuariosVO> list = new ArrayList<DatosUsuariosVO>();
		List<TourDatosUsuario> lista = (List<TourDatosUsuario>) UserBeanController.getInstance()
				.getEntities("TourDatosUsuario.findAll");
		for (TourDatosUsuario datosUsuario : lista) {
			list.add(getUserVoByEntities(datosUsuario));
		}
		return list;
	}
	
	public DatosUsuariosVO getUserbyDni(String dni) throws Exception {
		try {
			return getUserVoByEntities(
					(TourDatosUsuario) UserBeanController.getInstance().getUserByDni("TourDatosUsuario.findByDni", dni));
		} catch (Exception e) {
			log.error("Error logueando al usuario");
			throw new Exception(e);
		}
		
		
		
	}

	public DatosUsuariosVO getUserbyId(String id) {
		return  (DatosUsuariosVO) getUserVoByEntities((TourDatosUsuario)UserBeanController.getInstance().getDatosUsuario(id));
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
	private DatosUsuariosVO getUserVoByEntities(TourDatosUsuario usuario) {
		DatosUsuariosVO userVO = new DatosUsuariosVO(usuario.getDni(), usuario.getNombres(), usuario.getApellidos(),
				usuario.getCiudad(), usuario.getDireccion(), usuario.getEmail(), usuario.getMovil(), usuario.getPais());
		return userVO;
	}

	/**
	 * <b> Cargar la entidad desde los datos retornados por el VO</b>
	 * 
	 * @param usuario
	 * @return
	 */
	private TourDatosUsuario getEntityByUserVo(DatosUsuariosVO usuario) {
		TourDatosUsuario user = new TourDatosUsuario(usuario.getApellidos(), usuario.getCiudad(),
				usuario.getDireccion(), usuario.getDni(), usuario.getEmail(), usuario.getMovil(), usuario.getNombres(),
				usuario.getPais(), usuario.getMovil());
		return user;
	}

}
