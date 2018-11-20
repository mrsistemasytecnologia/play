package net.mrsistemas.play.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ELECTRONIC_CATEGORY database table.
 * 
 */
@Entity
@Table(name="ELECTRONIC_CATEGORY")
@NamedQueries({
@NamedQuery(name="ElectronicCategory.findAll", query="SELECT e FROM ElectronicCategory e"),
@NamedQuery(name="ElectronicCategory.findById", query="SELECT e FROM ElectronicCategory e where e.idCategory = ?1")

})
public class ElectronicCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CATEGORY")
	private String idCategory;

	private String description;

	private String name;

	//bi-directional many-to-one association to ElectronicDevice
	@OneToMany(mappedBy="electronicCategory")
	private Set<ElectronicDevice> electronicDevices;

	public ElectronicCategory() {
	}
	
	public ElectronicCategory(String idCategory, String description, String name,
			Set<ElectronicDevice> electronicDevices) {
		super();
		this.idCategory = idCategory;
		this.description = description;
		this.name = name;
		this.electronicDevices = electronicDevices;
	}

	public ElectronicCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ElectronicDevice> getElectronicDevices() {
		return this.electronicDevices;
	}

	public void setElectronicDevices(Set<ElectronicDevice> electronicDevices) {
		this.electronicDevices = electronicDevices;
	}

	public ElectronicDevice addElectronicDevice(ElectronicDevice electronicDevice) {
		getElectronicDevices().add(electronicDevice);
		electronicDevice.setElectronicCategory(this);

		return electronicDevice;
	}

	public ElectronicDevice removeElectronicDevice(ElectronicDevice electronicDevice) {
		getElectronicDevices().remove(electronicDevice);
		electronicDevice.setElectronicCategory(null);

		return electronicDevice;
	}

}