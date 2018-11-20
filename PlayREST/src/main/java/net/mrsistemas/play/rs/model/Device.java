package net.mrsistemas.play.rs.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlElement;

import net.mrsistemas.play.model.vo.DeviceVO;

public class Device extends Respuesta {

	private static final long serialVersionUID = -4595334701902576269L;
	
	@XmlElement(name = "lista")
	private Set<DeviceVO> deviceVOs;

	public Device() {}

	public Device(int iCodigo, String sestado, String smensaje) {
		super(iCodigo, sestado, smensaje);
	}

	public Device(int iCodigo, String sestado, String smensaje, String auth) {
		super(iCodigo, sestado, smensaje, auth);
	}

	public Device(int iCodigo, String sestado, String smensaje, String auth, Set<DeviceVO> deviceVOs) {
		super(iCodigo, sestado, smensaje, auth);
		this.setDeviceVOs(deviceVOs);
	}

	/**
	 * @return the deviceVOs
	 */
	public Set<DeviceVO> getDeviceVOs() {
		return deviceVOs;
	}

	/**
	 * @param deviceVOs the deviceVOs to set
	 */
	public void setDeviceVOs(Set<DeviceVO> deviceVOs) {
		this.deviceVOs = deviceVOs;
	}
	
	

}
