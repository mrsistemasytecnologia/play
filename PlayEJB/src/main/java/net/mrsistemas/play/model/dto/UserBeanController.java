package net.mrsistemas.play.model.dto;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mrsistemas.play.model.entities.GenSession;
import net.mrsistemas.play.model.vo.UsuarioVO;
import net.mrsistemas.play.remote.beans.IUsuariosEJBRemote;

public class UserBeanController {
	IUsuariosEJBRemote bean = null;
	private static final UserBeanController INSTANCE = new UserBeanController(); 
	private static final Logger log = LogManager.getLogger(UserBeanController.class.getName());
	
	private UserBeanController() {
		getUserBeanContext();
	}
	
	/**
	 * <b>Metodo que retorna una unica instancia de bean Controler,  para la gestión 
	 * de buissines Object de Usuario.</b>
	 * @return Instancia unica del UserBeanController.getInstance
	 */
	public static UserBeanController getInstance() {
		return INSTANCE;
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
			bean = (IUsuariosEJBRemote) ctx.lookup("userOperationBeans#net.mrsistemas.play.remote.beans.IUsuariosEJBRemote");
		} catch (final NamingException ne) {
			ne.printStackTrace();
			log.error(ne.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getLocalizedMessage());
		}
	}

	public Object persistEntity(Object usuario) {
		return bean.persistEntity(usuario);
	}
	
	public Object getEntities(String hql) {
		return bean.getEntities(hql);
	}
	
	
	public Object getDatosUsuario(String id) {
		return bean.findDatosUsuario(id);
	}
	
	public Object validaLogin(String id) {
		return bean.validaDatosSession(id);
	}
	
	public Object getLogin(String hql, UsuarioVO vo){
		return bean.getConsultaDosParametros(hql, vo.getUsuario(),vo.getPasswd());
	}
	
	public Object getSessionById(String hql, String auth){
		return bean.getEntitiesById(hql, auth);
	}

	public Object getUserByDni(String jpqlStmt, String dni) {
		return bean.getEntityById(jpqlStmt, dni);
	}
	
	public Object getSesssionUser(String jpqlStmt, GenSession login) {
		return bean.getConsultaDosParametros(jpqlStmt, login.getIdUsuario(), login.getHost());
	}
}
