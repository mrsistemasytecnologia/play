package net.mrsistemas.play.model.dto;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mrsistemas.play.model.entities.ElectronicDevice;
import net.mrsistemas.play.remote.beans.IDeviceBeanRemote;

public class DeviceBeanController {
	
	private static final DeviceBeanController INSTANCE = new DeviceBeanController();
	private static final Logger log = LogManager.getLogger(DeviceBeanController.class.getName());
	
	// Instancia del beans
	private IDeviceBeanRemote bean = null;
	
	// Start Transaction
	
	// Commit Transaction
	
	
	private DeviceBeanController() {
		getDeviceBeanContext();
	}
	
	public static DeviceBeanController getInstance() {
		return INSTANCE;
	}
	
	public ElectronicDevice createElectronicDevice(ElectronicDevice device){
		return bean.persistElectronicDevice(device);
	}
	
	public ElectronicDevice updateDevice(ElectronicDevice device){
		return bean.mergeElectronicDevice(device);
	}
	
	public ElectronicDevice getElectronicDevice(String id){
		return bean.getElectronicDeviceFindById(id).get(0);
	}
	
	public List<ElectronicDevice> getElectronicDeviceByUser(String user){	
		return bean.getElectronicDeviceFindByUsers(user);
	}
	
	
	public ElectronicDevice getElectronicDevice(String id, String user){
		return bean.getElectronicDeviceFindById(id, user).get(0);
	}
	
	public List<ElectronicDevice> getElectronicDevices(){
		return bean.getElectronicDeviceFindAll();
	}
	
	private void getDeviceBeanContext() {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		env.put(Context.SECURITY_PRINCIPAL, "weblogic");
		env.put(Context.SECURITY_CREDENTIALS, "weblogic1");
		env.put(Context.PROVIDER_URL, "t3://localhost:7101");
		try {
			Context ctx = new InitialContext(env);
			bean = (IDeviceBeanRemote) ctx
					.lookup("Java-EJBDeviceBean#net.mrsistemas.play.remote.beans.IDeviceBeanRemote");
		} catch (final NamingException ne) {
			log.error(ne.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getLocalizedMessage());
		}
		
	}
}
