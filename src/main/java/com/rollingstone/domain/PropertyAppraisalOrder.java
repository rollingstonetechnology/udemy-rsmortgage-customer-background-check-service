package com.rollingstone.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "rsmortgage_property_appraisal_order")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PropertyAppraisalOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	@OneToOne
	@JoinColumn(name="property_id")
	private RealEstateProperty property;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_ordered", unique = false, nullable = false, length = 10)
	private Date dateCreated;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_completed", unique = false, nullable = false, length = 10)
	private Date dateCompleted;
	
	@Column(nullable = false)
	private float propertyValue;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyAppraisal")
    @JsonManagedReference
	private Set<SimilarProperty> similarProperties = new HashSet<SimilarProperty>();
	
	
	public PropertyAppraisalOrder(){
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public RealEstateProperty getProperty() {
		return property;
	}


	public void setProperty(RealEstateProperty property) {
		this.property = property;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Date getDateCompleted() {
		return dateCompleted;
	}


	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}


	public float getPropertyValue() {
		return propertyValue;
	}


	public void setPropertyValue(float propertyValue) {
		this.propertyValue = propertyValue;
	}


	

	public Set<SimilarProperty> getSimilarProperties() {
		return similarProperties;
	}


	public void setSimilarProperties(Set<SimilarProperty> similarProperties) {
		this.similarProperties = similarProperties;
	}


	@Override
	public String toString() {
		return "PropertyAppraisalOrder [id=" + id + ", property=" + property + ", dateCreated=" + dateCreated
				+ ", dateCompleted=" + dateCompleted + ", propertyValue=" + propertyValue + ", addresses=" + similarProperties
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((similarProperties == null) ? 0 : similarProperties.hashCode());
		result = prime * result + ((dateCompleted == null) ? 0 : dateCompleted.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((property == null) ? 0 : property.hashCode());
		result = prime * result + Float.floatToIntBits(propertyValue);
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
		PropertyAppraisalOrder other = (PropertyAppraisalOrder) obj;
		if (similarProperties == null) {
			if (other.similarProperties != null)
				return false;
		} else if (!similarProperties.equals(other.similarProperties))
			return false;
		if (dateCompleted == null) {
			if (other.dateCompleted != null)
				return false;
		} else if (!dateCompleted.equals(other.dateCompleted))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (id != other.id)
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		if (Float.floatToIntBits(propertyValue) != Float.floatToIntBits(other.propertyValue))
			return false;
		return true;
	}


	public PropertyAppraisalOrder(long id, RealEstateProperty property, Date dateCreated, Date dateCompleted,
			float propertyValue, Set<SimilarProperty> similarProperties) {
		super();
		this.id = id;
		this.property = property;
		this.dateCreated = dateCreated;
		this.dateCompleted = dateCompleted;
		this.propertyValue = propertyValue;
		this.similarProperties = similarProperties;
	}
	
	
	
	
}
