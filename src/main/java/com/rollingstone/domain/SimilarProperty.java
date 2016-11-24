package com.rollingstone.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
 * A User POJO serving as an Entity as well as a Data Transfer Object i.e DTO
 */
@Entity
@Table(name = "rsmortgage_similar_property")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SimilarProperty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String propertyAddress;
	
	@Column(nullable = false)
	private double soldAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appraisal_id", nullable = false)
	@JsonBackReference
	PropertyAppraisalOrder propertyAppraisal;
	
	public SimilarProperty(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public double getSoldAmount() {
		return soldAmount;
	}

	public void setSoldAmount(double soldAmount) {
		this.soldAmount = soldAmount;
	}

	@Override
	public String toString() {
		return "SimilarProperty [id=" + id + ", propertyAddress=" + propertyAddress + ", soldAmount=" + soldAmount
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((propertyAddress == null) ? 0 : propertyAddress.hashCode());
		long temp;
		temp = Double.doubleToLongBits(soldAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SimilarProperty other = (SimilarProperty) obj;
		if (id != other.id)
			return false;
		if (propertyAddress == null) {
			if (other.propertyAddress != null)
				return false;
		} else if (!propertyAddress.equals(other.propertyAddress))
			return false;
		if (Double.doubleToLongBits(soldAmount) != Double.doubleToLongBits(other.soldAmount))
			return false;
		return true;
	}

	public SimilarProperty(long id, String propertyAddress, double soldAmount) {
		super();
		this.id = id;
		this.propertyAddress = propertyAddress;
		this.soldAmount = soldAmount;
	}
}
