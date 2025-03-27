package app.domain.models;

import java.sql.Date;

public class Invoice  {
	private long InvoiceId;
	private long PetId;
	private long OwnerId;
	private long OrderId;
	private String ProductName;
	private double worth;	
	private double amount;
	private Date Date;
	
	
	public Invoice(long invoiceId, long petId, long ownerId, long orderId, String productName, double worth,
			double amount, java.sql.Date date) {
		super();
		this.InvoiceId = invoiceId;
		this.PetId = petId;
		this.OwnerId = ownerId;
		this.OrderId = orderId;
		this.ProductName = productName;
		this.worth = worth;
		this.amount = amount;
		this.Date = date;
	}
	public long getInvoiceId() {
		return InvoiceId;
	}
	public void setInvoiceId(long invoiceId) {
		InvoiceId = invoiceId;
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
	public long getOrderId() {
		return OrderId;
	}
	public void setOrderId(long orderId) {
		OrderId = orderId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
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
	
	
	


