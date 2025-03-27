package app.ports;

import java.util.List;

import app.domain.models.ClinicalRecord;


public interface ClinicalRecordPort {

	public ClinicalRecord getClinicalRecordByClinicaId(long clinicaId)throws Exception;

	public void saveClinicaRecord(ClinicalRecord clinicaRecord)throws Exception;

	public ClinicalRecord getClinicaRecordByClinicaId(long clinicaId)throws Exception;

	public List<ClinicalRecord> getAllClinicalRecord()throws Exception;

	public ClinicalRecord getClinicaRecordByClnicaId(long clinicaId)throws Exception;

	public List<ClinicalRecord> getAllClinicaRecord()throws Exception;

}
