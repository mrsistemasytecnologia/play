package net.mrsistemas.play.remote.beans;


import java.util.Map;
import java.util.Set;

import javax.ejb.EJBException;

import net.mrsistemas.play.model.vo.CiudadVO;
import net.mrsistemas.play.model.vo.DatosUsuariosVO;
import net.mrsistemas.play.model.vo.DeviceVO;
import net.mrsistemas.play.model.vo.GenSessionVO;
import net.mrsistemas.play.model.vo.UsuarioVO;

public interface IFacadeUsuario {

	/**
	 * <p>
	 * Persistir los datos de sesion de un usuario en la
	 * base de datos.
	 * </p>
	 * 
	 * @param usuario
	 * @return
	 * @throws Exception 
	 */
	UsuarioVO saveUsuario(UsuarioVO usuario) throws Exception;

	/**
	 * <p>
	 * Persistir los datos de un usuario en la base de
	 * datos.
	 * </p>
	 * 
	 * @param usuario
	 * @return
	 * @throws Exception 
	 */
	DatosUsuariosVO saveUsuario(DatosUsuariosVO usuario) throws Exception;

	/**
	 * <p>
	 * Obtenemos un listado de usuarios registrados en la plataforma.
	 * <p>
	 * 
	 * @return
	 */
	Object getUsuarios();

	/**
	 * <p>
	 * Obtenemos un listado de usuarios registrados en la plataforma.
	 * <p>
	 * 
	 * @return
	 */
	Object getDatosUsuarios() throws Exception;

	/**
	 * <p>
	 * Obtenemos una instancia con los datos del usuario, si este se encuentra registrado..
	 * <p>
	 * 
	 * @param Usuario
	 * @param passwd
	 * @return
	 */
	public Object getValidado(UsuarioVO login) throws Exception;
	
	
	/**
	 * <b>Metodo que retorna si el usuario logueado tiene session activa<b/>
	 * @param auth
	 * @return
	 * @throws Exception
	 */
	public boolean isActiveSession(String auth) throws Exception;

	/**
	 * <p> Obtenemos los datos del usuario por el parametro de entrada.<p>
	 * 
	 * @param id
	 * @return usuario
	 */
	Object getUsuario(String id);

	/**
	 * <p> Obtenemos los datos del usuario por el parametro id de registro.<p>
	 * 
	 * @param id
	 * @return usuario
	 * @throws Exception 
	 */
	Object getUsuarioByDni(String id) throws Exception;
	
	/**
	 * <p> Almacenamos en bd los datos de la ciudad.<p>
	 * 
	 * @param id
	 * @return usuario
	 */
	Object saveCiudades(CiudadVO ciudad);
	
	/**
	 * <p> Obtenemos los datos de la ciudad pasada por parametro id de registro.<p>
	 * 
	 * @param id
	 * @return usuario
	 */
	Object getCityById(String id);
	
	/**
	 * <p> Obtenemos los datos del pais pasada por parametro id de registro.<p>
	 * 
	 * @param id
	 * @return DatosPais
	 */
	Object getPaisById(String id);
	
	/**
	 * <p> Obtenemos los datos de la ciudad pasada por parametro id de registro.<p>
	 *
	 * @return DatosPais
	 */
	Object getPais();

	/**
	 * <b>Este metodo retorna los datos de las ciudades registradas en el sistema.</b>
	 * @return <ListDTO>
	 */
	Object getCiudades();
	
	/**
	 * <p>Metodo para generar una session de usuario</p>
	 * @param usuario
	 * @return
	 * @throws Exception 
	 */
	GenSessionVO createSession(UsuarioVO usuario, String host) throws Exception;
	
	/**
	 * <p>Metodo para generar validar si existe una session de usuario activa</p>
	 * @param usuario
	 * @return
	 */
	GenSessionVO getSession(GenSessionVO login);
	
	/**
	 * <b>Metodo para crear un dispositivo electrónico en la base de datos.</b>
	 * @param device
	 * @return
	 * @throws EJBException
	 */
	DeviceVO getDevices() throws EJBException;
	
	/**
	 * <b>Metodo que retorna el dispositivo que se esté consultando por id<b>
	 * @param credentials
	 * @return
	 * @throws EJBException
	 */
	DeviceVO getDeviceById(Map<String, String> credentials) ;
	
	/**
	 * <b>Metodo que retorna una lista de los dispositivos que tiene el usuario.<b>
	 * @param id
	 * @param Users
	 * @return Lista de dispositivos
	 * @throws EJBException
	 */
	DeviceVO getDeviceByUsersId(String id, String Users);
	
	/**
	 * <b>Metodo que cambia el estado del dispositivo { INACTIVO  --> apagar } o { ACTIVO -->  encender }<b>
	 * @param id
	 * @return Dispositivo con el nuevo estado
	 * @throws EJBException
	 */
	DeviceVO updateDeviceById(Map<String, String> credentials) ;
	
	/**
	 * <b>Metodo mediante el cual se retornan los dispositivos registrados por los usuarios.</b>
	 * @param Users
	 * @return
	 * @throws EJBException
	 */
	public Set<DeviceVO> getDeviceByUsers(Map<String, String> credentials);
	
	/**
	 * <b>Metodo que cambia el estado a todos los dispositivos del usuario</b>
	 * @param id
	 * @param user
	 * @param operation
	 * @return
	 * @throws EJBException
	 */
	DeviceVO updateDevicesByUsers(Map<String, String> credentials) ;
	

}