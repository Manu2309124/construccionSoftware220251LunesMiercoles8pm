package app.adapters.clinicalorder.repository;


import app.adapters.clinicalrecord.entity.ClinicalRecordEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface ClinicalRecordRepository extends JpaRepository<ClinicalRecordEntity, Long> {

    List<ClinicalRecordEntity> findByDoctorId(Long doctorId);

    List<ClinicalRecordEntity> findByDate(Date date);

    List<ClinicalRecordEntity> findByDiagnosis(String diagnosis);

    List<ClinicalRecordEntity> findByReason(String reason);
}
