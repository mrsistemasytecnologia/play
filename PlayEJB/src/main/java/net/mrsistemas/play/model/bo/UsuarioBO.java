package net.mrsistemas.play.model.bo;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mrsistemas.play.model.dto.UserBeanController;
import net.mrsistemas.play.model.entities.GenSession;
import net.mrsistemas.play.model.entities.TourUsuario;
import net.mrsistemas.play.model.vo.GenSessionVO;
import net.mrsistemas.play.model.vo.UsuarioVO;

public class UsuarioBO {
	private static final Logger log = LogManager.getLogger(UsuarioBO.class.getName());

	public UsuarioBO() {}

	public UsuarioVO persistUser(UsuarioVO usuario) throws Exception {
		try {
			TourUsuario tourUsuario = (TourUsuario) UserBeanController.getInstance()
					.persistEntity(getEntityByUserVo(usuario));
			if (tourUsuario != null) {
				usuario = getUserVoByEntities(tourUsuario);
			} else {
				log.error("El usuario no existe: " + usuario.getUsuario());
			}
			return usuario;
		} catch (Exception e) {
			log.error("Se ha presentado un error con la consulta del usuario: [" + usuario.getUsuario() + "] "
					+ e.getLocalizedMessage());
			throw new Exception(e);
		}
	}

	public GenSessionVO createSessions(UsuarioVO usuario, String host) throws Exception {
		GenSession session = new GenSession();
		GenSessionVO sessionVo = null;

		// Loguear el usuario en la session
		usuario = getUserLogin(usuario);
		// Crear la instancia del objeto para crear la session
		session.setIdUsuario(usuario.getUsuarioId());
		session.setHost(host);
		// Consultar si la session ya existe
		try {
			sessionVo = getSessionVoByEntity(
					(GenSession) UserBeanController.getInstance().getSesssionUser("GenSession.findBySession", session));
		} catch (EJBException nre) {
			log.info("Session no existe");
		} catch (Exception e) {
			log.info("Session no existe");
		}
		// Generar la session del usuario en la bd
		if (sessionVo == null) {
			session = (GenSession) UserBeanController.getInstance().persistEntity(session);
			sessionVo = getSessionVoByEntity(
					(GenSession) UserBeanController.getInstance().getSesssionUser("GenSession.findBySession", session));
		}

		return sessionVo;
	}

	public GenSessionVO validaSession(GenSessionVO usuario) {
		return getSessionVoByEntity((GenSession) UserBeanController.getInstance().validaLogin(usuario.getIdSesion()));
	}

	@SuppressWarnings("unchecked")
	public List<UsuarioVO> getAllUser() {
		List<UsuarioVO> list = new ArrayList<UsuarioVO>();
		List<TourUsuario> lista = (List<TourUsuario>) UserBeanController.getInstance()
				.getEntities("TourUsuarios.findAll");
		for (TourUsuario usuario : lista) {
			list.add(getUserVoByEntities(usuario));
		}
		;
		return list;
	}

	public UsuarioVO getUserbyId() {
		UsuarioVO usuario = new UsuarioVO();

		return usuario;
	}

	public UsuarioVO updateUserbyId() {
		UsuarioVO usuario = new UsuarioVO();

		return usuario;
	}

	public UsuarioVO getUserLogin(UsuarioVO login) throws Exception {
		try {
			UsuarioVO usuario = getUserVoByEntities(
					(TourUsuario) UserBeanController.getInstance().getLogin("TourUsuarios.findByLogged", login));
			return usuario;
		} catch (Exception e) {
			log.error("Error logueando al usuario");
			throw new Exception(e);
		}
	}

	public UsuarioVO updateUser() {
		UsuarioVO usuario = new UsuarioVO();

		return usuario;
	}

	/**
	 * <b></b>
	 * 
	 * @param auth
	 * @throws Exception 
	 */
	public boolean getActiveSession(String auth) throws Exception {
		try {
			UserBeanController.getInstance().getSessionById("GenSession.findByIdSession", auth);
			return true;
		} catch (EJBException e) {
			log.warn("Session inválida,  usuario no tiene sessions activa." + e.getLocalizedMessage());
			return false;
		} catch (Exception e) {
			log.error("Error logueando al usuario" + e.getLocalizedMessage());
			throw new Exception(e);
		}

	}

	/**
	 * <b>Convierte una entidad persistente de usuario en un vo usuario</<b>
	 * 
	 * @param usuario
	 * @return
	 */
	private UsuarioVO getUserVoByEntities(TourUsuario usuario) {
		UsuarioVO userVO = new UsuarioVO(usuario.getUsuarioId(), usuario.getUsuario(), usuario.getPasswd());
		return userVO;
	}

	/**
	 * <b>Convierte un vo usuario en su entidad persistente,</b>
	 * 
	 * @param usuario
	 * @return {TourUsuario} retorna entidad persistente de usuario (Logueo)
	 */
	private TourUsuario getEntityByUserVo(UsuarioVO usuario) {
		TourUsuario userVO = new TourUsuario(usuario.getUsuarioId(), usuario.getUsuario(), usuario.getPasswd());
		return userVO;
	}

	/**
	 * <b>Convierte un vo session en su entidad persistente,</b>
	 * 
	 * @param usuario
	 * @return {TourUsuario} retorna entidad persistente de usuario (Logueo)
	 */
	@SuppressWarnings("unused")
	private GenSession getEntityBySessionVo(UsuarioVO usuario) {
		GenSession session = new GenSession();
		session.setIdUsuario(usuario.getUsuarioId());
		return session;
	}

	private GenSessionVO getSessionVoByEntity(GenSession session) {
		return new GenSessionVO(session.getIdSesion(), session.getFechaFin(), session.getFechaInicio(),
				session.getHost(), session.getIdUsuario(), session.getUsuarioCreacion());
	}
}
