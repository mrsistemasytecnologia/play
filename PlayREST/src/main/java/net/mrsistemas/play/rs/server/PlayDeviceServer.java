package net.mrsistemas.play.rs.server;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.spi.Contract;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.mrsistemas.play.controller.facade.Facade;
import net.mrsistemas.play.model.bo.UsuarioBO;
import net.mrsistemas.play.model.vo.DeviceVO;
import net.mrsistemas.play.model.vo.GenSessionVO;
import net.mrsistemas.play.remote.beans.IFacadeUsuario;
import net.mrsistemas.play.rs.model.Device;
import net.mrsistemas.play.rs.model.Respuesta;

@Path("/device")
public class PlayDeviceServer {
	private static final Logger LOG = LogManager.getLogger(UsuarioBO.class.getName());
	// Crear la instancia de acceso a las subaplicaciones JPA - EJB
	IFacadeUsuario userFacade = Facade.getInstance();
	// Formato para manejo de las fechas
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public PlayDeviceServer() {
	}

	/**
	 * <b>Meto que retorna todas las ciudades registradas en el sistema</b>
	 * 
	 * @param headers
	 * @param usuario
	 * @return Lista Ciudades
	 */

	@POST
	@Path(value = "/getDevicesStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDevicesStatus(@Context HttpHeaders headers, String inObject) {
		JsonParser parser = new JsonParser();
		ResponseBuilder r = Response.ok();
		System.out.println("Peticion: " + inObject);
		JsonObject gsonObject = parser.parse(inObject).getAsJsonObject();
		String auth = gsonObject.get("auth").getAsString();
		String id = gsonObject.get("device").getAsString();

		IFacadeUsuario facade = Facade.getInstance();
		GenSessionVO session = new GenSessionVO();
		session.setIdSesion(auth);

		try {
			// Validar si el usuario tiene una session activa para consultar
			// datos
			session = facade.getSession(session);
			if (session.getIdUsuario().isEmpty()) {
				r.entity(new Respuesta(20, "Error!", "La session ha terminado,  por favor ingrese de nuevo."));
				return r.build();
			}
			Set<DeviceVO> list = new HashSet<DeviceVO>();
			list.add(facade.getDeviceByUsersId(id, session.getIdUsuario()));
			Device device = new Device(0, "OK", "Operacion realizada de manera exitosa", auth, list);
			r.entity(device);
		} catch (Exception e) {
			LOG.error("Error 2566", e.getLocalizedMessage());
			r.entity(new Respuesta(2566, "Error",
					"Se ha presentado una error,  por favor contacte con el administrador del sistema, e indique el código Error: 2567."));
			return r.build();
		}
		return r.build();
	}

	/**
	 * <b>Meto que retorna todas las ciudades registradas en el sistema</b>
	 * 
	 * @param headers
	 * @param usuario
	 * @return Lista Ciudades
	 */

	@POST
	@Path(value = "/getDevicesByUsers")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDevicesByUser(@Context HttpHeaders headers, String inObject) {
		LOG.info("REQUEST: " + inObject);
		ResponseBuilder r = Response.ok();
		Map<String, String> credentials = new HashMap<String, String>();
		
		JsonParser parser = new JsonParser();
		JsonObject gsonObject = parser.parse(inObject).getAsJsonObject();
		String auth = gsonObject.get("auth").getAsString();

		credentials.put("auth", auth);

		LocalDate date = LocalDate.now();

		System.out.println("ha llegado la solicitud: " + date);
		System.out.println("auth: " + auth);

		IFacadeUsuario facade = Facade.getInstance();
		GenSessionVO session = new GenSessionVO();
		session.setIdSesion(auth);

		try {
			// Validar si el usuario tiene una session activa para consultar
			// datos
			session = facade.getSession(session);
			if (session.getIdUsuario().isEmpty()) {
				r.entity(new Respuesta(20, "Error!", "La session ha terminado,  por favor ingrese de nuevo."));
				return r.build();
			}
			credentials.put("userId", session.getIdUsuario());
			Set<DeviceVO> deviceVOs = facade.getDeviceByUsers(credentials);
			Device vo = new Device(0, "OK", "Operacion realizada de manera exitosa", auth, deviceVOs);
			r.entity(vo);
			return r.build();
		} catch (Exception e) {
			LOG.error("Error 2565", e.getLocalizedMessage());
			r.entity(new Device(2565, "Error",
					"Se ha presentado una error,  por favor contacte con el administrador del sistema, e indique el código Error: 2565."));
			return r.build();
		}
	}

	/**
	 * <b>Metodo que retorna todas las ciudades registradas en el sistema</b>
	 * 
	 * @param headers
	 * @param usuario
	 * @return Lista Ciudades
	 */

	@POST
	@Path(value = "/setDeviceState")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setDeviceState(@Context HttpHeaders headers, @QueryParam("device") String device,
			@QueryParam("state") String state) {
		ResponseBuilder r = Response.ok();
		IFacadeUsuario facade = Facade.getInstance();
		GenSessionVO session = new GenSessionVO();
		Set<DeviceVO> deviceVO = new HashSet<DeviceVO>();
		LOG.info("REQUEST: " + "{device:" +device+",state:"+state+"}");
		Map<String, String> credentials = new HashMap<String, String>();
		credentials.put("auth", headers.getHeaderString("auth"));
		credentials.put("state", state);
		credentials.put("deviceId", device);
		session.setIdSesion(credentials.get("auth"));

		try {
			// Validar si el usuario tiene una session activa para consultar
			// datos
			session = facade.getSession(session);
			if (session.getIdUsuario().isEmpty()) {
				r.entity(new Respuesta(20, "Error!", "La session ha terminado,  por favor ingrese de nuevo."));
				return r.build();
			}
			deviceVO.add(facade.updateDeviceById(credentials));
			Device vo = new Device(0, "OK", "Operacion realizada de manera exitosa", credentials.get("auth"), deviceVO);
			r.entity(vo);
			return r.build();
		} catch (Exception e) {
			LOG.error("Error 2565", e.getLocalizedMessage());
			r.entity(new Device(2565, "Error",
					"Se ha presentado una error,  por favor contacte con el administrador del sistema, e indique el código Error: 2565."));
			return r.build();
		}
	}
}
