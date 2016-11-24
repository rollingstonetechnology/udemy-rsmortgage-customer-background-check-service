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

/*
 * A User POJO serving as an Entity as well as a Data Transfer Object i.e DTO
 */
@Entity
@Table(name = "rsmortgage_loan_application")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoanApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_applied", unique = true, nullable = false, length = 10)
	private Date dateApplied;
	
	@OneToOne
	@JoinColumn(name="property_id")
	private RealEstateProperty propertyTobePurchased;
	
	@OneToOne
	@JoinColumn(name="bank_branch_id")
	private BankBranch bankBranch;
	
	@OneToOne
	@JoinColumn(name="property_appraisal_order_id")
	private PropertyAppraisalOrder propertyAppraisalOrder;
	
	@Column(nullable = false)
	private double originalCreditAmount;
	
	@Column(nullable = false)
	private String loanStatus;
	
	@Column(nullable = false)
	private boolean isApproved;
	
	@Column(nullable = false)
	private float rateOfInterest;
	
	@Column(nullable = false)
	private int numOfYears;
	
	@Column(nullable = false)
	private double isPMIRequired;
	
	@OneToOne
	@JoinColumn(name="loan_type_id")
	private LoanType loanTYpe;
	
	
	@Column(nullable = false)
	private int numOfInstallments;
	
	@Column(nullable = false)
	private float monthlyEMI;
	
	@Column(nullable = false)
	private float propertyTax;
	
	@Column(nullable = false)
	private float insuranceAmount;
	
	@Column(nullable = false)
	private boolean escrowAttached;
	
	@Column(nullable = false)
	private boolean GFEProvided;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loanApplication")
	private Set<LoanApplicant> applicants = new HashSet<LoanApplicant>();

	public Set<LoanApplicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(Set<LoanApplicant> applicants) {
		this.applicants = applicants;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}

	public RealEstateProperty getPropertyTobePurchased() {
		return propertyTobePurchased;
	}

	public void setPropertyTobePurchased(RealEstateProperty propertyTobePurchased) {
		this.propertyTobePurchased = propertyTobePurchased;
	}

	public BankBranch getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(BankBranch bankBranch) {
		this.bankBranch = bankBranch;
	}

	public PropertyAppraisalOrder getPropertyAppraisalOrder() {
		return propertyAppraisalOrder;
	}

	public void setPropertyAppraisalOrder(PropertyAppraisalOrder propertyAppraisalOrder) {
		this.propertyAppraisalOrder = propertyAppraisalOrder;
	}

	public double getOriginalCreditAmount() {
		return originalCreditAmount;
	}

	public void setOriginalCreditAmount(double originalCreditAmount) {
		this.originalCreditAmount = originalCreditAmount;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public float getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public int getNumOfYears() {
		return numOfYears;
	}

	public void setNumOfYears(int numOfYears) {
		this.numOfYears = numOfYears;
	}

	public double getIsPMIRequired() {
		return isPMIRequired;
	}

	public void setIsPMIRequired(double isPMIRequired) {
		this.isPMIRequired = isPMIRequired;
	}

	public LoanType getLoanTYpe() {
		return loanTYpe;
	}

	public void setLoanTYpe(LoanType loanTYpe) {
		this.loanTYpe = loanTYpe;
	}

	public int getNumOfInstallments() {
		return numOfInstallments;
	}

	public void setNumOfInstallments(int numOfInstallments) {
		this.numOfInstallments = numOfInstallments;
	}

	public float getMonthlyEMI() {
		return monthlyEMI;
	}

	public void setMonthlyEMI(float monthlyEMI) {
		this.monthlyEMI = monthlyEMI;
	}

	public float getPropertyTax() {
		return propertyTax;
	}

	public void setPropertyTax(float propertyTax) {
		this.propertyTax = propertyTax;
	}

	public float getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(float insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public boolean isEscrowAttached() {
		return escrowAttached;
	}

	public void setEscrowAttached(boolean escrowAttached) {
		this.escrowAttached = escrowAttached;
	}

	public boolean isGFEProvided() {
		return GFEProvided;
	}

	public void setGFEProvided(boolean gFEProvided) {
		GFEProvided = gFEProvided;
	}
	
	public LoanApplication(){
		
	}

	@Override
	public String toString() {
		return "LoanApplication [id=" + id + ", dateApplied=" + dateApplied + ", propertyTobePurchased="
				+ propertyTobePurchased + ", bankBranch=" + bankBranch + ", propertyAppraisalOrder="
				+ propertyAppraisalOrder + ", originalCreditAmount=" + originalCreditAmount + ", loanStatus="
				+ loanStatus + ", isApproved=" + isApproved + ", rateOfInterest=" + rateOfInterest + ", numOfYears="
				+ numOfYears + ", isPMIRequired=" + isPMIRequired + ", loanTYpe=" + loanTYpe + ", numOfInstallments="
				+ numOfInstallments + ", monthlyEMI=" + monthlyEMI + ", propertyTax=" + propertyTax
				+ ", insuranceAmount=" + insuranceAmount + ", escrowAttached=" + escrowAttached + ", GFEProvided="
				+ GFEProvided + ", getId()=" + getId() + ", getDateApplied()=" + getDateApplied()
				+ ", getPropertyTobePurchased()=" + getPropertyTobePurchased() + ", getBankBranch()=" + getBankBranch()
				+ ", getPropertyAppraisalOrder()=" + getPropertyAppraisalOrder() + ", getOriginalCreditAmount()="
				+ getOriginalCreditAmount() + ", getLoanStatus()=" + getLoanStatus() + ", isApproved()=" + isApproved()
				+ ", getRateOfInterest()=" + getRateOfInterest() + ", getNumOfYears()=" + getNumOfYears()
				+ ", getIsPMIRequired()=" + getIsPMIRequired() + ", getLoanTYpe()=" + getLoanTYpe()
				+ ", getNumOfInstallments()=" + getNumOfInstallments() + ", getMonthlyEMI()=" + getMonthlyEMI()
				+ ", getPropertyTax()=" + getPropertyTax() + ", getInsuranceAmount()=" + getInsuranceAmount()
				+ ", isEscrowAttached()=" + isEscrowAttached() + ", isGFEProvided()=" + isGFEProvided()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (GFEProvided ? 1231 : 1237);
		result = prime * result + ((bankBranch == null) ? 0 : bankBranch.hashCode());
		result = prime * result + ((dateApplied == null) ? 0 : dateApplied.hashCode());
		result = prime * result + (escrowAttached ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Float.floatToIntBits(insuranceAmount);
		result = prime * result + (isApproved ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(isPMIRequired);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((loanStatus == null) ? 0 : loanStatus.hashCode());
		result = prime * result + ((loanTYpe == null) ? 0 : loanTYpe.hashCode());
		result = prime * result + Float.floatToIntBits(monthlyEMI);
		result = prime * result + numOfInstallments;
		result = prime * result + numOfYears;
		temp = Double.doubleToLongBits(originalCreditAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((propertyAppraisalOrder == null) ? 0 : propertyAppraisalOrder.hashCode());
		result = prime * result + Float.floatToIntBits(propertyTax);
		result = prime * result + ((propertyTobePurchased == null) ? 0 : propertyTobePurchased.hashCode());
		result = prime * result + Float.floatToIntBits(rateOfInterest);
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
		LoanApplication other = (LoanApplication) obj;
		if (GFEProvided != other.GFEProvided)
			return false;
		if (bankBranch == null) {
			if (other.bankBranch != null)
				return false;
		} else if (!bankBranch.equals(other.bankBranch))
			return false;
		if (dateApplied == null) {
			if (other.dateApplied != null)
				return false;
		} else if (!dateApplied.equals(other.dateApplied))
			return false;
		if (escrowAttached != other.escrowAttached)
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(insuranceAmount) != Float.floatToIntBits(other.insuranceAmount))
			return false;
		if (isApproved != other.isApproved)
			return false;
		if (Double.doubleToLongBits(isPMIRequired) != Double.doubleToLongBits(other.isPMIRequired))
			return false;
		if (loanStatus == null) {
			if (other.loanStatus != null)
				return false;
		} else if (!loanStatus.equals(other.loanStatus))
			return false;
		if (loanTYpe == null) {
			if (other.loanTYpe != null)
				return false;
		} else if (!loanTYpe.equals(other.loanTYpe))
			return false;
		if (Float.floatToIntBits(monthlyEMI) != Float.floatToIntBits(other.monthlyEMI))
			return false;
		if (numOfInstallments != other.numOfInstallments)
			return false;
		if (numOfYears != other.numOfYears)
			return false;
		if (Double.doubleToLongBits(originalCreditAmount) != Double.doubleToLongBits(other.originalCreditAmount))
			return false;
		if (propertyAppraisalOrder == null) {
			if (other.propertyAppraisalOrder != null)
				return false;
		} else if (!propertyAppraisalOrder.equals(other.propertyAppraisalOrder))
			return false;
		if (Float.floatToIntBits(propertyTax) != Float.floatToIntBits(other.propertyTax))
			return false;
		if (propertyTobePurchased == null) {
			if (other.propertyTobePurchased != null)
				return false;
		} else if (!propertyTobePurchased.equals(other.propertyTobePurchased))
			return false;
		if (Float.floatToIntBits(rateOfInterest) != Float.floatToIntBits(other.rateOfInterest))
			return false;
		return true;
	}

	public LoanApplication(long id, Date dateApplied, RealEstateProperty propertyTobePurchased, BankBranch bankBranch,
			PropertyAppraisalOrder propertyAppraisalOrder, double originalCreditAmount, String loanStatus,
			boolean isApproved, float rateOfInterest, int numOfYears, double isPMIRequired, LoanType loanTYpe,
			int numOfInstallments, float monthlyEMI, float propertyTax, float insuranceAmount, boolean escrowAttached,
			boolean gFEProvided) {
		super();
		this.id = id;
		this.dateApplied = dateApplied;
		this.propertyTobePurchased = propertyTobePurchased;
		this.bankBranch = bankBranch;
		this.propertyAppraisalOrder = propertyAppraisalOrder;
		this.originalCreditAmount = originalCreditAmount;
		this.loanStatus = loanStatus;
		this.isApproved = isApproved;
		this.rateOfInterest = rateOfInterest;
		this.numOfYears = numOfYears;
		this.isPMIRequired = isPMIRequired;
		this.loanTYpe = loanTYpe;
		this.numOfInstallments = numOfInstallments;
		this.monthlyEMI = monthlyEMI;
		this.propertyTax = propertyTax;
		this.insuranceAmount = insuranceAmount;
		this.escrowAttached = escrowAttached;
		GFEProvided = gFEProvided;
	}
	
	
	
	
	
	
	
	
}
