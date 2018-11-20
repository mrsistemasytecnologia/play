package net.mrsistemas.play.rs.server;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mrsistemas.play.controller.facade.Facade;
import net.mrsistemas.play.model.bo.UsuarioBO;
import net.mrsistemas.play.model.vo.CiudadVO;
import net.mrsistemas.play.model.vo.GenSessionVO;
import net.mrsistemas.play.remote.beans.IFacadeUsuario;
import net.mrsistemas.play.rs.model.Ciudad;

@SuppressWarnings("unchecked")
@Path("cities")
public class PlayCitiesServer {
	private static final Logger log = LogManager.getLogger(UsuarioBO.class.getName());
	// Crear la instancia de acceso a las subaplicaciones JPA - EJB
	IFacadeUsuario userFacade = Facade.getInstance();
	// Formato para manejo de las fechas
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public PlayCitiesServer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * <b>Metodo que retorna todas las ciudades donde el usuario tiene
	 * dispositivos.</b>
	 * 
	 * @param headers
	 * @param usuario
	 * @param codCiudad
	 * @return
	 */
	@POST
	@Path(value = "/getCitiesByUsers")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCitiesByUsers(@Context HttpHeaders headers, String inDatos) {
		System.out.println("Entrada:  " + inDatos);
		// Creacion del objeto de entrada de datos multiple
		GenSessionVO usuario = null;
		System.out.println("Usuario vo: " + usuario);
		System.out.println("Ciudad: " + usuario);
		Ciudad ciudad = null;
		
		
		
		
		// Intancia para acceder a las propiedades de los diferntes elementos
		// del sistema.
		IFacadeUsuario facade = Facade.getInstance();
		ResponseBuilder r = Response.ok();

		try {
			// Validar si el usuario tiene una session activa para consultar
			// datos
			GenSessionVO login = facade.getSession(usuario);
			if (login == null) {
				ciudad = new Ciudad(20, "Error!", "La session ha terminado,  por favor ingrese de nuevo.");
				r.entity(ciudad);
				return r.build();
			}
			CiudadVO vOCiudad = (CiudadVO) facade.getCityById("u001");
			ciudad = new Ciudad(0, "OK", "Consulta exitosa", login.getIdSesion(), vOCiudad);
			r.entity(ciudad);
			return r.build();
		} catch (Exception e) {
			ciudad = new Ciudad(2564, "Error",
					"Se ha presentado una error,  por favor contacte con el administrador del sistema, e indique el código Error: 2564.");
			log.error("Error 2564", e.getLocalizedMessage());
			r.entity(ciudad);
			return r.build();
		}

	}

	/**
	 * <b>Meto que retorna todas las ciudades registradas en el sistema</b>
	 * 
	 * @param headers
	 * @param usuario
	 * @return Lista Ciudades
	 */
	
	@POST
	@Path(value = "/getCities")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCities(@Context HttpHeaders headers, String auth) {
		System.out.println("Usuario vo: " + auth);
		Ciudad ciudad = null;
		// Intancia para acceder a las propiedades de los diferntes elementos
		// del sistema.
		IFacadeUsuario facade = Facade.getInstance();
		// Crear el objeto de respuesta a la petición
		ResponseBuilder r = Response.ok();
		try {
			// Validar si el usuario tiene una session activa para consultar
			// datos
			
			if (facade.isActiveSession(auth)) {
				ciudad = new Ciudad(20, "Error!", "La session ha terminado,  por favor ingrese de nuevo.");
				r.entity(ciudad);
				return r.build();
			}
			List<CiudadVO> vOCiudad = (List<CiudadVO>) facade.getCiudades();
			ciudad = new Ciudad(0,"OK","Consulta exitosa",auth, vOCiudad);
			r.entity(ciudad);
			return r.build();
		} catch (Exception e) {
			ciudad = new Ciudad(2564, "Error",
					"Se ha presentado una error,  por favor contacte con el administrador del sistema, e indique el código Error: 2564.");
			log.error("Error 2564", e.getLocalizedMessage());
			r.entity(ciudad);
			return r.build();
		}

	}

}
