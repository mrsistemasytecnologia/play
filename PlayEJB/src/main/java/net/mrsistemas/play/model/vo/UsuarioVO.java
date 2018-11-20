package net.mrsistemas.play.model.vo;

public class UsuarioVO {
	private String usuarioId;
	private String passwd;
	private String usuario;
	
	public UsuarioVO() {
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioVO(String usuarioId, String usuario, String passwd) {
		super();
		this.usuarioId = usuarioId;
		this.passwd = passwd;
		this.usuario = usuario;
	}

	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioVO [usuarioId=");
		builder.append(usuarioId);
		builder.append(", passwd=");
		builder.append(passwd);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append("]");
		return builder.toString();
	}

}
