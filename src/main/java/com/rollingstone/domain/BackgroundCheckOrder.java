package com.rollingstone.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "rsmortgage_background_check_order")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BackgroundCheckOrder {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name="loan_application_id")
	private LoanApplication loanApplication;
	
	@Column(nullable = false)
	private boolean isCreditCheckOrdered;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "credit_check_order_date", unique = true, nullable = false, length = 10)
	Date	creditCheckOderedDate;
	
	@Column(nullable = false)
	private boolean isCriminalCheckOrder;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "criminal_check_order_date", unique = true, nullable = false, length = 10)
	Date criminalCheckOderedDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "backgroundCheckOrder" , cascade=CascadeType.ALL)
    @JsonManagedReference
	private Set<BackgroundCheckOrderDetail> pastYearsAddresses = new HashSet<BackgroundCheckOrderDetail>();
	
	public BackgroundCheckOrder(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isCreditCheckOrdered() {
		return isCreditCheckOrdered;
	}

	public void setCreditCheckOrdered(boolean isCreditCheckOrdered) {
		this.isCreditCheckOrdered = isCreditCheckOrdered;
	}

	public Date getCreditCheckOderedDate() {
		return creditCheckOderedDate;
	}

	public void setCreditCheckOderedDate(Date creditCheckOderedDate) {
		this.creditCheckOderedDate = creditCheckOderedDate;
	}

	public boolean isCriminalCheckOrder() {
		return isCriminalCheckOrder;
	}

	public void setCriminalCheckOrder(boolean isCriminalCheckOrder) {
		this.isCriminalCheckOrder = isCriminalCheckOrder;
	}

	public Date getCriminalCheckOderedDate() {
		return criminalCheckOderedDate;
	}

	public void setCriminalCheckOderedDate(Date criminalCheckOderedDate) {
		this.criminalCheckOderedDate = criminalCheckOderedDate;
	}

	

	

	public LoanApplication getLoanApplication() {
		return loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}

	public Set<BackgroundCheckOrderDetail> getPastYearsAddresses() {
		return pastYearsAddresses;
	}

	public void setPastYearsAddresses(Set<BackgroundCheckOrderDetail> pastYearsAddresses) {
		this.pastYearsAddresses = pastYearsAddresses;
	}

	@Override
	public String toString() {
		return "BackgroundCheckOrder [id=" + id + ", isCreditCheckOrdered=" + isCreditCheckOrdered
				+ ", creditCheckOderedDate=" + creditCheckOderedDate + ", isCriminalCheckOrder=" + isCriminalCheckOrder
				+ ", criminalCheckOderedDat=" + criminalCheckOderedDate + ", creditScoreFExperian="
				+ ", pastYearsAddresses=" + pastYearsAddresses + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditCheckOderedDate == null) ? 0 : creditCheckOderedDate.hashCode());
		result = prime * result + ((criminalCheckOderedDate == null) ? 0 : criminalCheckOderedDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isCreditCheckOrdered ? 1231 : 1237);
		result = prime * result + (isCriminalCheckOrder ? 1231 : 1237);
		result = prime * result + ((pastYearsAddresses == null) ? 0 : pastYearsAddresses.hashCode());
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
		BackgroundCheckOrder other = (BackgroundCheckOrder) obj;
	
		if (creditCheckOderedDate == null) {
			if (other.creditCheckOderedDate != null)
				return false;
		} else if (!creditCheckOderedDate.equals(other.creditCheckOderedDate))
			return false;
		if (criminalCheckOderedDate == null) {
			if (other.criminalCheckOderedDate != null)
				return false;
		} else if (!criminalCheckOderedDate.equals(other.criminalCheckOderedDate))
			return false;
		if (id != other.id)
			return false;
		if (isCreditCheckOrdered != other.isCreditCheckOrdered)
			return false;
		if (isCriminalCheckOrder != other.isCriminalCheckOrder)
			return false;
		if (pastYearsAddresses == null) {
			if (other.pastYearsAddresses != null)
				return false;
		} else if (!pastYearsAddresses.equals(other.pastYearsAddresses))
			return false;
		return true;
	}

	public BackgroundCheckOrder(long id, boolean isCreditCheckOrdered, Date creditCheckOderedDate,
			boolean isCriminalCheckOrder, Date criminalCheckOderedDat, int creditScoreFExperian,
			int creditScoreFromTransunion, int creditScoreFromOthers, int averageCreditScore,
			Set<BackgroundCheckOrderDetail> pastYearsAddresses) {
		super();
		this.id = id;
		this.isCreditCheckOrdered = isCreditCheckOrdered;
		this.creditCheckOderedDate = creditCheckOderedDate;
		this.isCriminalCheckOrder = isCriminalCheckOrder;
		this.criminalCheckOderedDate = criminalCheckOderedDat;
		this.pastYearsAddresses = pastYearsAddresses;
	}
	
	
}
