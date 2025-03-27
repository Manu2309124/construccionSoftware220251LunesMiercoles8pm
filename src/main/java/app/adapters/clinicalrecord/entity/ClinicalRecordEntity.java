package app.adapters.clinicalrecord.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Clinical_Record")
public class ClinicalRecordEntity {
	@Id
	@Column(name="ClinicalRecord_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Order_Id")
	private long  OrderId;
	@Column(name="date")
	private Date date;
	@Column(name="Doctor_Id")
	private long DoctorId;
	@Column(name="reason")
	private String reason;
	@Column(name="symptoms")
	private String symptoms;
	@Column(name="diagnosis")
	private String diagnosis;
	@Column(name="procedure")
	private String procedure;
	@Column(name="medicine")
	private String medicine;
	@Column(name="dose")
	private String dose;
	@Column(name="vaccination_History")
	private String vaccinationHistory;
	@Column(name="allergy_medication")
	private String allergyMedication;
	@Column(name="detail_procedure")
	private String detailProcedure;
	@Column(name="annulment_order")
	private String annulmentOrder;
	public long getClinicalRecordId() {
		return ClinicalRecordId;
	}
	public void setClinicalRecordId(long clinicalRecordId) {
		ClinicalRecordId = clinicalRecordId;
	}
	public long getOrderId() {
		return OrderId;
	}
	public void setOrderId(long orderId) {
		OrderId = orderId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getDoctorId() {
		return DoctorId;
	}
	public void setDoctorId(long doctorId) {
		DoctorId = doctorId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getProcedure() {
		return procedure;
	}
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public String getVaccinationHistory() {
		return vaccinationHistory;
	}
	public void setVaccinationHistory(String vaccinationHistory) {
		this.vaccinationHistory = vaccinationHistory;
	}
	public String getAllergyMedication() {
		return allergyMedication;
	}
	public void setAllergyMedication(String allergyMedication) {
		this.allergyMedication = allergyMedication;
	}
	public String getDetailProcedure() {
		return detailProcedure;
	}
	public void setDetailProcedure(String detailProcedure) {
		this.detailProcedure = detailProcedure;
	}
	public String getAnnulmentOrder() {
		return annulmentOrder;
	}
	public void setAnnulmentOrder(String annulmentOrder) {
		this.annulmentOrder = annulmentOrder;
	}
}


	