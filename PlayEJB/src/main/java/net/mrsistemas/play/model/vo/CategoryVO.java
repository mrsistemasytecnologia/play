package net.mrsistemas.play.model.vo;

import javax.xml.bind.annotation.XmlElement;

public class CategoryVO {
	@XmlElement(name = "id")
	private String idCategory;
	private String description;
	private String name;

	public CategoryVO() {}
	
	public CategoryVO(String idCategory) {
		super();
		this.idCategory = idCategory;
	}

	public CategoryVO(String idCategory, String description, String name) {
		super();
		this.idCategory = idCategory;
		this.description = description;
		this.name = name;
	}



	public String getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
