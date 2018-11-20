package net.mrsistemas.play.model.vo;

public class GenSessionVO {
	
	private String idSesion;
	private String fechaFin;
	private String fechaInicio;
	private String host;
	private String idUsuario;
	private String usuarioCreacion;

	public GenSessionVO() {}

	public GenSessionVO(String idSesion, String fechaFin, String fechaInicio, String host, String idUsuario,
			String usuarioCreacion) {
		super();
		this.idSesion = idSesion;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.host = host;
		this.idUsuario = idUsuario;
		this.usuarioCreacion = usuarioCreacion;
	}

	public GenSessionVO(String idSesion, String idUsuario) {
		super();
		this.idSesion = idSesion;
		this.idUsuario = idUsuario;
	}

	public String getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GenSessionVO [idSesion=");
		builder.append(idSesion);
		builder.append(", fechaFin=");
		builder.append(fechaFin);
		builder.append(", fechaInicio=");
		builder.append(fechaInicio);
		builder.append(", host=");
		builder.append(host);
		builder.append(", idUsuario=");
		builder.append(idUsuario);
		builder.append(", usuarioCreacion=");
		builder.append(usuarioCreacion);
		builder.append("]");
		return builder.toString();
	}
	
	

}
