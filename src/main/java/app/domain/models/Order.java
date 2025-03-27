package app.domain.models;

import java.sql.Date;

public class Order {
	private long OrderId;
	private long PetId;
	private long OwnerId;
	private long VeterinaryId;
	private String MedicineName;
	private Date DateGeneration;
	public Order(long orderId, long petId, long ownerId, long veterinaryId, String medicineName,
			Date dateGeneration) {
		super();
		this.OrderId = orderId;
		this.PetId = petId;
		this.OwnerId = ownerId;
		this.VeterinaryId = veterinaryId;
		this.MedicineName = medicineName;
		this.DateGeneration = dateGeneration;
	}
	public long getOrderId() {
		return OrderId;
	}
	public void setOrderId(long orderId) {
		OrderId = orderId;
	}
	public long getPetId() {
		return PetId;
	}
	public void setPetId(long petId) {
		PetId = petId;
	}
	public long getOwnerId() {
		return OwnerId;
	}
	public void setOwnerId(long ownerId) {
		OwnerId = ownerId;
	}
	public long getVeterinaryId() {
		return VeterinaryId;
	}
	public void setVeterinaryId(long veterinaryId) {
		VeterinaryId = veterinaryId;
	}
	public String getMedicineName() {
		return MedicineName;
	}
	public void setMedicineName(String medicineName) {
		MedicineName = medicineName;
	}
	public Date getDateGeneration() {
		return DateGeneration;
	}
	public void setDateGeneration(Date dateGeneration) {
		DateGeneration = dateGeneration;
	}
	

	
	
	
}


}
