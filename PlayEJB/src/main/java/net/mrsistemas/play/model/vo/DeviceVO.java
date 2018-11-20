package net.mrsistemas.play.model.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import net.mrsistemas.play.model.entities.ElectronicCategory;

public class DeviceVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2456852952525818246L;
	@XmlElement(name = "id")
	private String deviceId;
	private String name;
	private CategoryVO category;
	private String usuarioId;
	private String state;

	public DeviceVO(String deviceId, String name, CategoryVO category, String usuarioId, String state) {
		super();
		this.deviceId = deviceId;
		this.name = name;
		this.category = category;
		this.usuarioId = usuarioId;
		this.state = state;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public CategoryVO getCategory() {
		return category;
	}

	public void setCategory(CategoryVO category) {
		this.category = category;
	}
	
	private ElectronicCategory adapterCategory(CategoryVO cat) {
		return new ElectronicCategory(cat.getIdCategory(), cat.getDescription(), cat.getName(), null);
	}
	
	private CategoryVO adapterCategory(ElectronicCategory cat) {
		return new  CategoryVO(cat.getIdCategory(), cat.getDescription(),cat.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeviceVO [deviceId=").append(deviceId).append(", name=").append(name).append(", category=")
				.append(category).append(", usuarioId=").append(usuarioId).append(", state=").append(state).append("]");
		return builder.toString();
	}

}
