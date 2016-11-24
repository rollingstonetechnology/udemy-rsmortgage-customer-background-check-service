package com.rollingstone.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * A User POJO serving as an Entity as well as a Data Transfer Object i.e DTO
 */
@Entity
@Table(name = "rsmortgage_real_estate_property")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RealEstateProperty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name="property_type_id")
	private PropertyType propertyType;
	
	@Column(nullable = false)
	private int yearBuilt;
	
	@Column(nullable = false)
	private double currentPrice;
	
	@Column(nullable = false)
	private float currentTax;
	
	@Column(nullable = false)
	private String ownerName;
	
	@Column(nullable = false)
	private String ownerPhone;
	
	@Column(nullable = false)
	private String ownerEmail;
	
	@Column(nullable = false)
	private boolean isFullyOwned;
	
	@Column(nullable = false)
	private boolean isDamaged;
	
	@Column(nullable = false)
	private boolean isForeClosed;
	
	@Column(nullable = false)
	private String currentLender;
	
	@Column(nullable = false)
	private int numFloors;
	
	@Column(nullable = false)
	private int numRooms;
	
	@Column(nullable = false)
	private int numFullBaths;
	
	@Column(nullable = false)
	private int numHalfBaths;
	
	@Column(nullable = false)
	private float lotArea;
	
	@Column(nullable = false)
	private int numGaragaes;
	
	@Column(nullable = false)
	private boolean isGagageAttached;
	
	@Column(nullable = false)
	private boolean hasUtilityRoom;
	
	@Column(nullable = false)
	private int numClosets;
	
	@Column(nullable = false)
	private boolean hasStromDoor;
	
	@Column(nullable = false)
	private boolean hasSumpPumpInstalled;
	
	@Column(nullable = false)
	private boolean washerIncluded;
	
	@Column(nullable = false)
	private boolean dryerIncluded;
	
	@Column(nullable = false)
	private boolean refrigeratorIncluded;
	
	@Column(nullable = false)
	private boolean isLAndSCaped;
	
	@Column(nullable = false)
	private boolean sprinklerInstalled;
	
	@Column(nullable = false)
	private boolean dishWasherInstalled;
	
	@Column(nullable = false)
	private boolean fenceInstalled;
	
	@Column(nullable = false)
	private String heatingSopurce;
	
	@Column(nullable = false)
	private boolean acInstalled;
	
	@Column(nullable = false)
	private boolean microwaveInstalled;
	
	@Column(nullable = false)
	private boolean hasBasement;
	
	@Column(nullable = false)
	private boolean isFinishedBasement;
	
	public RealEstateProperty(){
	
	}
	public int getNumFloors() {
		return numFloors;
	}

	public void setNumFloors(int numFloors) {
		this.numFloors = numFloors;
	}

	public int getNumRooms() {
		return numRooms;
	}

	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}

	public int getNumFullBaths() {
		return numFullBaths;
	}

	public void setNumFullBaths(int numFullBaths) {
		this.numFullBaths = numFullBaths;
	}

	public int getNumHalfBaths() {
		return numHalfBaths;
	}

	public void setNumHalfBaths(int numHalfBaths) {
		this.numHalfBaths = numHalfBaths;
	}

	public float getLotArea() {
		return lotArea;
	}

	public void setLotArea(float lotArea) {
		this.lotArea = lotArea;
	}

	public int getNumGaragaes() {
		return numGaragaes;
	}

	public void setNumGaragaes(int numGaragaes) {
		this.numGaragaes = numGaragaes;
	}

	public boolean isGagageAttached() {
		return isGagageAttached;
	}

	public void setGagageAttached(boolean isGagageAttached) {
		this.isGagageAttached = isGagageAttached;
	}

	public boolean isHasUtilityRoom() {
		return hasUtilityRoom;
	}

	public void setHasUtilityRoom(boolean hasUtilityRoom) {
		this.hasUtilityRoom = hasUtilityRoom;
	}

	public int getNumClosets() {
		return numClosets;
	}

	public void setNumClosets(int numClosets) {
		this.numClosets = numClosets;
	}

	public boolean isHasStromDoor() {
		return hasStromDoor;
	}

	public void setHasStromDoor(boolean hasStromDoor) {
		this.hasStromDoor = hasStromDoor;
	}

	public boolean isHasSumpPumpInstalled() {
		return hasSumpPumpInstalled;
	}

	public void setHasSumpPumpInstalled(boolean hasSumpPumpInstalled) {
		this.hasSumpPumpInstalled = hasSumpPumpInstalled;
	}

	public boolean isWasherIncluded() {
		return washerIncluded;
	}

	public void setWasherIncluded(boolean washerIncluded) {
		this.washerIncluded = washerIncluded;
	}

	public boolean isDryerIncluded() {
		return dryerIncluded;
	}

	public void setDryerIncluded(boolean dryerIncluded) {
		this.dryerIncluded = dryerIncluded;
	}

	public boolean isRefrigeratorIncluded() {
		return refrigeratorIncluded;
	}

	public void setRefrigeratorIncluded(boolean refrigeratorIncluded) {
		this.refrigeratorIncluded = refrigeratorIncluded;
	}

	public boolean isLAndSCaped() {
		return isLAndSCaped;
	}

	public void setLAndSCaped(boolean isLAndSCaped) {
		this.isLAndSCaped = isLAndSCaped;
	}

	public boolean isSprinklerInstalled() {
		return sprinklerInstalled;
	}

	public void setSprinklerInstalled(boolean sprinklerInstalled) {
		this.sprinklerInstalled = sprinklerInstalled;
	}

	public boolean isDishWasherInstalled() {
		return dishWasherInstalled;
	}

	public void setDishWasherInstalled(boolean dishWasherInstalled) {
		this.dishWasherInstalled = dishWasherInstalled;
	}

	public boolean isFenceInstalled() {
		return fenceInstalled;
	}

	public void setFenceInstalled(boolean fenceInstalled) {
		this.fenceInstalled = fenceInstalled;
	}

	public String getHeatingSopurce() {
		return heatingSopurce;
	}

	public void setHeatingSopurce(String heatingSopurce) {
		this.heatingSopurce = heatingSopurce;
	}

	public boolean isAcInstalled() {
		return acInstalled;
	}

	public void setAcInstalled(boolean acInstalled) {
		this.acInstalled = acInstalled;
	}

	public boolean isMicrowaveInstalled() {
		return microwaveInstalled;
	}

	public void setMicrowaveInstalled(boolean microwaveInstalled) {
		this.microwaveInstalled = microwaveInstalled;
	}

	public boolean isHasBasement() {
		return hasBasement;
	}

	public void setHasBasement(boolean hasBasement) {
		this.hasBasement = hasBasement;
	}

	public boolean isFinishedBasement() {
		return isFinishedBasement;
	}

	public void setFinishedBasement(boolean isFinishedBasement) {
		this.isFinishedBasement = isFinishedBasement;
	}

	@OneToOne
	@JoinColumn(name="owner_address_id")
	private Address ownerAddress;
	
	@OneToOne
	@JoinColumn(name="property_address_id")
	private Address propertyAddress;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public float getCurrentTax() {
		return currentTax;
	}

	public void setCurrentTax(float currentTax) {
		this.currentTax = currentTax;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public boolean isFullyOwned() {
		return isFullyOwned;
	}

	public void setFullyOwned(boolean isFullyOwned) {
		this.isFullyOwned = isFullyOwned;
	}

	public boolean isDamaged() {
		return isDamaged;
	}

	public void setDamaged(boolean isDamaged) {
		this.isDamaged = isDamaged;
	}

	public boolean isForeClosed() {
		return isForeClosed;
	}

	public void setForeClosed(boolean isForeClosed) {
		this.isForeClosed = isForeClosed;
	}

	public String getCurrentLender() {
		return currentLender;
	}

	public void setCurrentLender(String currentLender) {
		this.currentLender = currentLender;
	}

	public Address getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(Address ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public Address getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(Address propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	@Override
	public String toString() {
		return "RealEstateProperty [id=" + id + ", propertyType=" + propertyType + ", yearBuilt=" + yearBuilt
				+ ", currentPrice=" + currentPrice + ", currentTax=" + currentTax + ", ownerName=" + ownerName
				+ ", ownerPhone=" + ownerPhone + ", ownerEmail=" + ownerEmail + ", isFullyOwned=" + isFullyOwned
				+ ", isDamaged=" + isDamaged + ", isForeClosed=" + isForeClosed + ", currentLender=" + currentLender
				+ ", ownerAddress=" + ownerAddress + ", propertyAddress=" + propertyAddress + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentLender == null) ? 0 : currentLender.hashCode());
		long temp;
		temp = Double.doubleToLongBits(currentPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(currentTax);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isDamaged ? 1231 : 1237);
		result = prime * result + (isForeClosed ? 1231 : 1237);
		result = prime * result + (isFullyOwned ? 1231 : 1237);
		result = prime * result + ((ownerAddress == null) ? 0 : ownerAddress.hashCode());
		result = prime * result + ((ownerEmail == null) ? 0 : ownerEmail.hashCode());
		result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result + ((ownerPhone == null) ? 0 : ownerPhone.hashCode());
		result = prime * result + ((propertyAddress == null) ? 0 : propertyAddress.hashCode());
		result = prime * result + ((propertyType == null) ? 0 : propertyType.hashCode());
		result = prime * result + yearBuilt;
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
		RealEstateProperty other = (RealEstateProperty) obj;
		if (currentLender == null) {
			if (other.currentLender != null)
				return false;
		} else if (!currentLender.equals(other.currentLender))
			return false;
		if (Double.doubleToLongBits(currentPrice) != Double.doubleToLongBits(other.currentPrice))
			return false;
		if (Float.floatToIntBits(currentTax) != Float.floatToIntBits(other.currentTax))
			return false;
		if (id != other.id)
			return false;
		if (isDamaged != other.isDamaged)
			return false;
		if (isForeClosed != other.isForeClosed)
			return false;
		if (isFullyOwned != other.isFullyOwned)
			return false;
		if (ownerAddress == null) {
			if (other.ownerAddress != null)
				return false;
		} else if (!ownerAddress.equals(other.ownerAddress))
			return false;
		if (ownerEmail == null) {
			if (other.ownerEmail != null)
				return false;
		} else if (!ownerEmail.equals(other.ownerEmail))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (ownerPhone == null) {
			if (other.ownerPhone != null)
				return false;
		} else if (!ownerPhone.equals(other.ownerPhone))
			return false;
		if (propertyAddress == null) {
			if (other.propertyAddress != null)
				return false;
		} else if (!propertyAddress.equals(other.propertyAddress))
			return false;
		if (propertyType == null) {
			if (other.propertyType != null)
				return false;
		} else if (!propertyType.equals(other.propertyType))
			return false;
		if (yearBuilt != other.yearBuilt)
			return false;
		return true;
	}

	public RealEstateProperty(long id, PropertyType propertyType, int yearBuilt, double currentPrice, float currentTax,
			String ownerName, String ownerPhone, String ownerEmail, boolean isFullyOwned, boolean isDamaged,
			boolean isForeClosed, String currentLender, Address ownerAddress, Address propertyAddress) {
		super();
		this.id = id;
		this.propertyType = propertyType;
		this.yearBuilt = yearBuilt;
		this.currentPrice = currentPrice;
		this.currentTax = currentTax;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.ownerEmail = ownerEmail;
		this.isFullyOwned = isFullyOwned;
		this.isDamaged = isDamaged;
		this.isForeClosed = isForeClosed;
		this.currentLender = currentLender;
		this.ownerAddress = ownerAddress;
		this.propertyAddress = propertyAddress;
	}
	
	
}
