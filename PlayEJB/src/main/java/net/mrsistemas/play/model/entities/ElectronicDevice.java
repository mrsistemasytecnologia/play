package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ELECTRONIC_DEVICE database table.
 * 
 */
@Entity
@Table(name = "ELECTRONIC_DEVICE")
@NamedQueries({ @NamedQuery(name = "ElectronicDevice.findAll", query = "SELECT e FROM ElectronicDevice e"),
		@NamedQuery(name = "ElectronicDevice.findById", query = "SELECT e FROM ElectronicDevice e where e.deviceId = ?1"),
		@NamedQuery(name = "ElectronicDevice.findByUserId", query = "SELECT e FROM ElectronicDevice e where e.deviceId = ?1 and e.usuarioId = ?2"),
		@NamedQuery(name = "ElectronicDevice.findByUsers", query = "SELECT e FROM ElectronicDevice e where e.usuarioId = ?1") })
public class ElectronicDevice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DEVICE_ID")
	private String deviceId;

	private String estado;

	private String name;

	@Column(name = "USUARIO_ID")
	private String usuarioId;

	// bi-directional many-to-one association to ElectronicCategory
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORIA")
	private ElectronicCategory electronicCategory;

	public ElectronicDevice() {
	}

	public ElectronicDevice(String deviceId, String estado, String name, String usuarioId,
			ElectronicCategory electronicCategory) {
		super();
		this.deviceId = deviceId;
		this.estado = estado;
		this.name = name;
		this.usuarioId = usuarioId;
		this.electronicCategory = electronicCategory;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public ElectronicCategory getElectronicCategory() {
		return this.electronicCategory;
	}

	public void setElectronicCategory(ElectronicCategory electronicCategory) {
		this.electronicCategory = electronicCategory;
	}

}