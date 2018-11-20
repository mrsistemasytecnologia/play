package net.mrsistemas.play.model.dto;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mrsistemas.play.model.entities.GenCiudad;
import net.mrsistemas.play.remote.beans.IUsuariosEJBRemote;

public class CityBeanController {
	private static final CityBeanController INSTANCE = new CityBeanController();

	IUsuariosEJBRemote bean;
	private static final Logger log = LogManager.getLogger(CityBeanController.class.getName());
	private CityBeanController() {
		getUserBeanContext();
	}

	public static final CityBeanController getInstance() {
		return INSTANCE;
	}

	/**
	 * <b>Almacena en base de datos los datos de la ciudad Consultada.</b>
	 * @param ciudad
	 * @return
	 */
	public GenCiudad setCityInDatabase(GenCiudad ciudad) {
		return bean.persistEntity(ciudad);
	}
	
	/**
	 * <b>Retorna los datos de la ciudad consultada por ID</b>
	 * @param id
	 * @return Datos de la ciudad por ID
	 */
	public Object getDatosCiudad(String id) {
		return bean.findCityById(id);
	}
	
	/**
	 * <b>Retorna los datos de la ciudad consultada por ID</b>
	 * @param id
	 * @return Datos de la ciudad por ID
	 */
	public Object getCityByHql(String hql,String id) {
		return bean.getEntityById(hql, id);
	}
	
	/**
	 * <bRetorna los datos de las ciudades almacenadas en la BD.</b>
	 * @param hql
	 * @return
	 */
	public Object getAllCities(String hql) {
		return bean.getEntities(hql);
	}

	/**
	 * <p>
	 * Creamos el contexto para el beans de procesos de usuario.
	 * </p>
	 */
	private void getUserBeanContext() {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		env.put(Context.SECURITY_PRINCIPAL, "weblogic");
		env.put(Context.SECURITY_CREDENTIALS, "weblogic1");
		env.put(Context.PROVIDER_URL, "t3://localhost:7101");
		try {
			Context ctx = new InitialContext(env);
			bean = (IUsuariosEJBRemote) ctx
					.lookup("useroperation#net.mrsistemas.play.remote.beans.IUsuariosEJBRemote");
		} catch (final NamingException ne) {
			log.error(ne.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getLocalizedMessage());
		}
	}

}
