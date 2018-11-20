package net.mrsistemas.play.controller.facade;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJBException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mrsistemas.play.model.bo.CiudadBO;
import net.mrsistemas.play.model.bo.DatosUsuarioBO;
import net.mrsistemas.play.model.bo.DeviceBO;
import net.mrsistemas.play.model.bo.UsuarioBO;
import net.mrsistemas.play.model.vo.CiudadVO;
import net.mrsistemas.play.model.vo.DatosUsuariosVO;
import net.mrsistemas.play.model.vo.DeviceVO;
import net.mrsistemas.play.model.vo.GenSessionVO;
import net.mrsistemas.play.model.vo.UsuarioVO;
import net.mrsistemas.play.remote.beans.IFacadeUsuario;

/**
 * <b>Se usa el platrón facade para la entrada a las sub-aplicaciones mediante
 * una sola instancia.</b>
 * 
 * @author Max Fredis Tovar Hernandez
 * @version 1.0 -- Creacion de las opciones iniciales del facade
 */
public class Facade implements IFacadeUsuario {
	private static final IFacadeUsuario INSTANCE = new Facade();
	private static final Logger logger = LogManager.getLogger(Facade.class.getName());

	// Instancias de los bussines object
	UsuarioBO userBO = new UsuarioBO();
	DatosUsuarioBO datosUsuarioBO = new DatosUsuarioBO();
	DeviceBO deviceBO = new DeviceBO();
	CiudadBO ciudadBO = new CiudadBO();

	/**
	 * Constructor privado para tener solo una instancia del facade.
	 */
	private Facade() {
	}

	/**
	 * <p>
	 * Creaci�n de la instancia para el proceso de las diferentes operaciones
	 * del bean.
	 * </p>
	 * 
	 * @return Instancia �nica
	 */
	public static IFacadeUsuario getInstance() {
		return INSTANCE;
	}

	/**
	 * <b>Metodo para guardar informacion de logueo de usuario en la base de
	 * datos</b>
	 * 
	 * @throws Exception
	 */
	@Override
	public UsuarioVO saveUsuario(UsuarioVO usuario) throws Exception {
		return userBO.persistUser(usuario);
	}

	/**
	 * <b>Metodo para guardar informacion del usuario el base de datos.</b>
	 * 
	 * @return true : Dato Almacenado | false : Dato no almacenado
	 * @throws Exception
	 */
	@Override
	public DatosUsuariosVO saveUsuario(DatosUsuariosVO usuario) throws Exception {
		return datosUsuarioBO.persistUser(usuario);

	}

	/**
	 * <b>Metodo para obtener los usuario registrados en el sistema.</b>
	 * 
	 * @return lista de usuarios.
	 */
	@Override
	public Object getUsuarios() {
		return userBO.getAllUser();
	}

	/**
	 * <b>Metodo para obtener los datos personales de los usuarios </b>
	 * 
	 * @return Lista de datos de usuarios.
	 * @author Max Fredis Tovar
	 */
	@Override
	public List<DatosUsuariosVO> getDatosUsuarios() {
		return datosUsuarioBO.getAllUser();
	}

	/**
	 * Consultamos el usuario para saber si existe en el sistema.
	 * 
	 * @throws Exception
	 */
	public UsuarioVO getValidado(UsuarioVO login) throws Exception {
		return userBO.getUserLogin(login);
	}

	public boolean isActiveSession(String auth) throws Exception {
		return userBO.getActiveSession(auth);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tour.ws.model.facade.IFacadeUsuario#getUsuarios()
	 */
	@Override
	public DatosUsuariosVO getUsuario(String id) {
		return datosUsuarioBO.getUserbyId(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tour.ws.model.facade.IFacadeUsuario#getUsuarios()
	 */
	@Override
	public DatosUsuariosVO getUsuarioByDni(String dni) throws Exception {
		return datosUsuarioBO.getUserbyDni(dni);
	}

	@Override
	public Object saveCiudades(CiudadVO ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCityById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPaisById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPais() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCiudades() {
		return ciudadBO.getAllcities();
	}

	@Override
	public GenSessionVO getSession(GenSessionVO login) {
		return userBO.validaSession(login);
	}

	@Override
	public GenSessionVO createSession(UsuarioVO usuario, String host) throws Exception {
		logger.info("");
		return userBO.createSessions(usuario, host);

	}

	@Override
	public DeviceVO getDevices() throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceVO getDeviceById(Map<String, String> credentials) throws EJBException {
		return deviceBO.getDeviceById(credentials.get("deviceId"));
	}

	@Override
	public DeviceVO getDeviceByUsersId(String id, String Users) {
		DeviceVO device = deviceBO.getDeviceByUsersId(id, Users);
		return device;
	}

	@Override
	public Set<DeviceVO> getDeviceByUsers(Map<String, String> credentials) {
		try {
			Set<DeviceVO> lista = deviceBO.getDeviceByUsers(credentials.get("userId"));
			return lista;
		} catch (EJBException e) {
			logger.error("La consulta no arrojo ningún resultado.");
			logger.error(e.getLocalizedMessage());
			throw new EJBException(e);
		} catch (Exception e) {
			throw new EJBException(e);
		}

	}

	@Override
	public DeviceVO updateDeviceById(Map<String, String> credentials) {
		DeviceVO device =  getDeviceById(credentials);
		device.setState(credentials.get("state"));
		device =  deviceBO.updateDeviceById(device);
		return device;
	}

	@Override
	public DeviceVO updateDevicesByUsers(Map<String, String> credentials) throws EJBException {
		// String id, String user, String operation
		// TODO Auto-generated method stub
		return null;
	}

}