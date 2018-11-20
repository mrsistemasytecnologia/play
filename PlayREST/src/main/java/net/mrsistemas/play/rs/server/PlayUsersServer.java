package net.mrsistemas.play.rs.server;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mrsistemas.play.controller.facade.Facade;
import net.mrsistemas.play.model.bo.UsuarioBO;
import net.mrsistemas.play.model.vo.DatosUsuariosVO;
import net.mrsistemas.play.model.vo.GenSessionVO;
import net.mrsistemas.play.model.vo.UsuarioVO;
import net.mrsistemas.play.remote.beans.IFacadeUsuario;
import net.mrsistemas.play.rs.model.DatosUsuarios;
import net.mrsistemas.play.rs.model.Respuesta;

@Path("users")
public class PlayUsersServer {
	private static final Logger LOG = LogManager.getLogger(UsuarioBO.class.getName());
	// Crear la instancia de acceso a las subaplicaciones JPA - EJB
	IFacadeUsuario userFacade = Facade.getInstance();

	// Formato para manejo de las fechas
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public PlayUsersServer() {
		// TODO Auto-generated constructor stub
	}

	@POST
	@Path(value = "/GetSaludoUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSaludaUsuario(@Context HttpHeaders headers, String nombre) {
		LocalDate date = LocalDate.now();
		LOG.info("Petición llego con exito.");
		DatosUsuariosVO datos = new DatosUsuariosVO("8870375", "Max Fredis", "Tovar Hernandez", "Cartagena",
				"Cra 80 c # 8 - 53 ", "maxther911@gmail.com", "3014687812", "Colombia");
		DatosUsuarios usuario = new DatosUsuarios(0, "OK", "Consulta realizada de manera exitosa.", null, datos);
		ResponseBuilder r = Response.ok();
		r.entity(usuario);
		return r.build();
	}

	@POST
	@Path(value = "/GetLogin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response getLogin(@Context HttpHeaders headers, UsuarioVO usuario) {
		// Momento en que entró la peticioón
		String now = LocalDateTime.now().format(formatter);
		LOG.info("Usuario: " + usuario);
		List<String> host = headers.getRequestHeader(HttpHeaders.HOST);
		ResponseBuilder r = null;
		DatosUsuarios datosUsuarios = null;
		// Validar si el usuario tiene acceso al sistema
		try {
			usuario = (UsuarioVO) userFacade.getValidado(usuario);
			GenSessionVO sessions = userFacade.createSession(usuario, host.get(0).toString());
			Set<DatosUsuariosVO> datos = new HashSet<DatosUsuariosVO>();

			datos.add((DatosUsuariosVO) userFacade.getUsuario(usuario.getUsuarioId()));
			datosUsuarios = new DatosUsuarios(0, "OK", "Consulta realizada de manera exitosa.", sessions.getIdSesion(),
					datos);
			r = Response.ok();
			r.entity(datosUsuarios);
			r.header("auth", sessions.getIdSesion());
		} catch (NoResultException nre) {
			LOG.error(nre.getLocalizedMessage());
			r = Response.ok().status(Response.Status.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			r = Response.ok();
			if (e instanceof NoResultException) {
				r.entity(new DatosUsuarios(10, "ERROR", "Usuario inválido."));
			} else {
				r.entity(new Respuesta(20, "ERROR.", "Sistema no disponible, por favor intente mas tarde."));
			}
			r.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		return r.build();
	}

}
