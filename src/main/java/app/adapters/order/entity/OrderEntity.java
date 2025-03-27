package app.adapters.order.entity;

import java.sql.Date;

//import app.adapters.pet.entity.PetEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Order")
public class OrderEntity {
	@Id
	@Column(name="Order_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long OrderId;
	@OneToOne
	@JoinColumn(name = "pet_id")
	private long petId;
	@OneToOne
	@JoinColumn(name = "owner_id")
	private long  ownerId;
	@OneToOne
	@JoinColumn(name = "veterinary_id")
	private long veterinaryId;
	@Column(name = "Medicine_Name")
	private String MedicineName;
	@Column(name = " Date_Generation")
	private Date DateGeneration;
	public long getOrderId() {
		return OrderId;
	}
	public void setOrderId(long orderId) {
		OrderId = orderId;
	}
	public long getPetId() {
		return petId;
	}
	public void setPetId(long petId) {
		this.petId = petId;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public long getVeterinaryId() {
		return veterinaryId;
	}
	public void setVeterinaryId(long veterinaryId) {
		this.veterinaryId = veterinaryId;
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