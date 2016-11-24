package com.rollingstone.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "rsmortgage_background_check_report")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BackgroundCheckReport {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private boolean isCreditCheckOrdered;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "cc_order_date", unique = true, nullable = false, length = 10)
	Date	creditCheckOderedDate;
	
	@Column(nullable = false)
	private boolean isCriminalCheckOrder;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "criminal_record_order_date", unique = true, nullable = false, length = 10)
	Date criminalCheckOderedDate;
	
	@Column(nullable = false)
	private int creditScoreFExperian;
	
	@Column(nullable = false)
	private int creditScoreFromTransunion;
	
	@Column(nullable = false)
	private int creditScoreFromOthers;
	
	@Column(nullable = false)
	private int averageCreditScore;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "background_check_report_date", unique = true, nullable = false, length = 10)
	Date backgroundCheckReportDate;
	
	@Column(nullable = false)
	private boolean isRecommended;
	
	@OneToOne
	@JoinColumn(name="background_check_order_id")
	private BackgroundCheckOrder backgroundCheckOrder;
	
	public BackgroundCheckReport(){
		
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

	public int getCreditScoreFExperian() {
		return creditScoreFExperian;
	}

	public void setCreditScoreFExperian(int creditScoreFExperian) {
		this.creditScoreFExperian = creditScoreFExperian;
	}

	public int getCreditScoreFromTransunion() {
		return creditScoreFromTransunion;
	}

	public void setCreditScoreFromTransunion(int creditScoreFromTransunion) {
		this.creditScoreFromTransunion = creditScoreFromTransunion;
	}

	public int getCreditScoreFromOthers() {
		return creditScoreFromOthers;
	}

	public void setCreditScoreFromOthers(int creditScoreFromOthers) {
		this.creditScoreFromOthers = creditScoreFromOthers;
	}

	public int getAverageCreditScore() {
		return averageCreditScore;
	}

	public void setAverageCreditScore(int averageCreditScore) {
		this.averageCreditScore = averageCreditScore;
	}

	

	
	public Date getBackgroundCheckReportDate() {
		return backgroundCheckReportDate;
	}

	public void setBackgroundCheckReportDate(Date backgroundCheckReportDate) {
		this.backgroundCheckReportDate = backgroundCheckReportDate;
	}

	public boolean isRecommended() {
		return isRecommended;
	}

	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}

	
	public BackgroundCheckOrder getBackgroundCheckOrder() {
		return backgroundCheckOrder;
	}

	public void setBackgroundCheckOrder(BackgroundCheckOrder backgroundCheckOrder) {
		this.backgroundCheckOrder = backgroundCheckOrder;
	}

	@Override
	public String toString() {
		return "BackgroundCheckReport [id=" + id + ", isCreditCheckOrdered=" + isCreditCheckOrdered
				+ ", creditCheckOderedDate=" + creditCheckOderedDate + ", isCriminalCheckOrder=" + isCriminalCheckOrder
				+ ", criminalCheckOderedDate=" + criminalCheckOderedDate + ", creditScoreFExperian="
				+ creditScoreFExperian + ", creditScoreFromTransunion=" + creditScoreFromTransunion
				+ ", creditScoreFromOthers=" + creditScoreFromOthers + ", averageCreditScore=" + averageCreditScore
				+ backgroundCheckReportDate + ", isRecommended=" + isRecommended + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + averageCreditScore;
		result = prime * result + ((backgroundCheckReportDate == null) ? 0 : backgroundCheckReportDate.hashCode());
		result = prime * result + ((creditCheckOderedDate == null) ? 0 : creditCheckOderedDate.hashCode());
		result = prime * result + creditScoreFExperian;
		result = prime * result + creditScoreFromOthers;
		result = prime * result + creditScoreFromTransunion;
		result = prime * result + ((criminalCheckOderedDate == null) ? 0 : criminalCheckOderedDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isCreditCheckOrdered ? 1231 : 1237);
		result = prime * result + (isCriminalCheckOrder ? 1231 : 1237);
		result = prime * result + (isRecommended ? 1231 : 1237);
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
		BackgroundCheckReport other = (BackgroundCheckReport) obj;
		if (averageCreditScore != other.averageCreditScore)
			return false;
		if (backgroundCheckReportDate == null) {
			if (other.backgroundCheckReportDate != null)
				return false;
		} else if (!backgroundCheckReportDate.equals(other.backgroundCheckReportDate))
			return false;
		if (creditCheckOderedDate == null) {
			if (other.creditCheckOderedDate != null)
				return false;
		} else if (!creditCheckOderedDate.equals(other.creditCheckOderedDate))
			return false;
		if (creditScoreFExperian != other.creditScoreFExperian)
			return false;
		if (creditScoreFromOthers != other.creditScoreFromOthers)
			return false;
		if (creditScoreFromTransunion != other.creditScoreFromTransunion)
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
		if (isRecommended != other.isRecommended)
			return false;
		return true;
	}

	public BackgroundCheckReport(long id, boolean isCreditCheckOrdered, Date creditCheckOderedDate,
			boolean isCriminalCheckOrder, Date criminalCheckOderedDate, int creditScoreFExperian,
			int creditScoreFromTransunion, int creditScoreFromOthers, int averageCreditScore,
			List<Address> pastYearsAddresses, Date backgroundCheckReportDate, boolean isRecommended) {
		super();
		this.id = id;
		this.isCreditCheckOrdered = isCreditCheckOrdered;
		this.creditCheckOderedDate = creditCheckOderedDate;
		this.isCriminalCheckOrder = isCriminalCheckOrder;
		this.criminalCheckOderedDate = criminalCheckOderedDate;
		this.creditScoreFExperian = creditScoreFExperian;
		this.creditScoreFromTransunion = creditScoreFromTransunion;
		this.creditScoreFromOthers = creditScoreFromOthers;
		this.averageCreditScore = averageCreditScore;
		this.backgroundCheckReportDate = backgroundCheckReportDate;
		this.isRecommended = isRecommended;
	}

	
}
