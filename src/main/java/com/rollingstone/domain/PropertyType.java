package com.rollingstone.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "rsmortgage_property_type")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PropertyType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String propertyTypeName;
	
	@Column(nullable = false)
	private String propertyTypeDescription;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPropertyTypeName() {
		return propertyTypeName;
	}

	public void setPropertyTypeName(String propertyTypeName) {
		this.propertyTypeName = propertyTypeName;
	}

	public String getPropertyTypeDescription() {
		return propertyTypeDescription;
	}

	public void setPropertyTypeDescription(String propertyTypeDescription) {
		this.propertyTypeDescription = propertyTypeDescription;
	}

	public PropertyType(){
		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((propertyTypeDescription == null) ? 0 : propertyTypeDescription.hashCode());
		result = prime * result + ((propertyTypeName == null) ? 0 : propertyTypeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyType other = (PropertyType) obj;
		if (id != other.id)
			return false;
		if (propertyTypeDescription == null) {
			if (other.propertyTypeDescription != null)
				return false;
		} else if (!propertyTypeDescription.equals(other.propertyTypeDescription))
			return false;
		if (propertyTypeName == null) {
			if (other.propertyTypeName != null)
				return false;
		} else if (!propertyTypeName.equals(other.propertyTypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PropertyType [id=" + id + ", propertyTypeName=" + propertyTypeName + ", propertyTypeDescription="
				+ propertyTypeDescription + "]";
	}

	public PropertyType(long id, String propertyTypeName, String propertyTypeDescription) {
		super();
		this.id = id;
		this.propertyTypeName = propertyTypeName;
		this.propertyTypeDescription = propertyTypeDescription;
	}



	
}
