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
@Table(name = "rsmortgage_loan_type")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoanType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String loanTypeName;
	
	@Column(nullable = false)
	private String loanTypeDescription;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoanTypeName() {
		return loanTypeName;
	}

	public void setLoanTypeName(String loanTypeName) {
		this.loanTypeName = loanTypeName;
	}

	public String getLoanTypeDescription() {
		return loanTypeDescription;
	}

	public void setLoanTypeDescription(String loanTypeDescription) {
		this.loanTypeDescription = loanTypeDescription;
	}

	@Override
	public String toString() {
		return "LoanType [id=" + id + ", loanTypeName=" + loanTypeName + ", loanTypeDescription=" + loanTypeDescription
				+ "]";
	}

	public LoanType(){
		
	}
	
	public LoanType(long id, String loanTypeName, String loanTypeDescription) {
		super();
		this.id = id;
		this.loanTypeName = loanTypeName;
		this.loanTypeDescription = loanTypeDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((loanTypeDescription == null) ? 0 : loanTypeDescription.hashCode());
		result = prime * result + ((loanTypeName == null) ? 0 : loanTypeName.hashCode());
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
		LoanType other = (LoanType) obj;
		if (id != other.id)
			return false;
		if (loanTypeDescription == null) {
			if (other.loanTypeDescription != null)
				return false;
		} else if (!loanTypeDescription.equals(other.loanTypeDescription))
			return false;
		if (loanTypeName == null) {
			if (other.loanTypeName != null)
				return false;
		} else if (!loanTypeName.equals(other.loanTypeName))
			return false;
		return true;
	}

	


	
}
