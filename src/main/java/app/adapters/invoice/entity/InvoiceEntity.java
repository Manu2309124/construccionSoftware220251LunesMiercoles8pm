package app.adapters.invoice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="invoice")
public class InvoiceEntity {
	@Id
	@Column(name="invoice_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long invoiceId;
	@Column(name = "pet_id")
	private long petId;
	@Column(name = "owner_id")
	private long ownerId;
	@Column(name = "order_id")
	private long orderId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "worth")
	private double worth;
	@Column(name = "amount")
	private double amount;
	@Column(name = "date")
	private Date Date;
	public long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
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
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getWorth() {
		return worth;
	}
	public void setWorth(double worth) {
		this.worth = worth;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}



	

}
