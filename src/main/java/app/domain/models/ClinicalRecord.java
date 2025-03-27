package app.domain.models;

import java.sql.Date;

public class ClinicalRecord {
	private long ClinicalRecordId;
	private Date date;
	private long DoctorId;
	private String reason;
	private String symptoms;
	private String diagnosis;
	private String procedure;
	private String medicine;
	private String dose;
	private long  OrderId;
	private String vaccinationHistory;
	private String AllergyMedication;
	private String DetailProcedure;
	private String AnnulmentOrder;
	public ClinicalRecord(long clinicalRecordId, Date date, long doctorId, String reason, String symptoms,
			String diagnosis, String procedure, String medicine, String dose, long orderId, String vaccinationHistory,
			String allergyMedication, String detailProcedure, String annulmentOrder) {
		super();
		this.ClinicalRecordId = clinicalRecordId;
		this.date = date;
		this.DoctorId = doctorId;
		this.reason = reason;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.procedure = procedure;
		this.medicine = medicine;
		this.dose = dose;
		this.OrderId = orderId;
		this.vaccinationHistory = vaccinationHistory;
		this.AllergyMedication = allergyMedication;
		this.DetailProcedure = detailProcedure;
		this.AnnulmentOrder = annulmentOrder;
	}
	public long getClinicalRecordId() {
		return ClinicalRecordId;
	}
	public void setClinicalRecordId(long clinicalRecordId) {
		ClinicalRecordId = clinicalRecordId;
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
	public long getOrderId() {
		return OrderId;
	}
	public void setOrderId(long orderId) {
		OrderId = orderId;
	}
	public String getVaccinationHistory() {
		return vaccinationHistory;
	}
	public void setVaccinationHistory(String vaccinationHistory) {
		this.vaccinationHistory = vaccinationHistory;
	}
	public String getAllergyMedication() {
		return AllergyMedication;
	}
	public void setAllergyMedication(String allergyMedication) {
		AllergyMedication = allergyMedication;
	}
	public String getDetailProcedure() {
		return DetailProcedure;
	}
	public void setDetailProcedure(String detailProcedure) {
		DetailProcedure = detailProcedure;
	}
	public String getAnnulmentOrder() {
		return AnnulmentOrder;
	}
	public void setAnnulmentOrder(String annulmentOrder) {
		AnnulmentOrder = annulmentOrder;
	}
	
}