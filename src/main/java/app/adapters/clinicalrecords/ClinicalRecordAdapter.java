package app.adapters.clinicalrecords;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.clinicalorder.repository.ClinicalRecordRepository;
import app.adapters.clinicalrecord.entity.ClinicalRecordEntity;
import app.adapters.order.entity.OrderEntity;
import app.adapters.person.entity.PersonEntity;
import app.adapters.pet.entity.PetEntity;
import app.adapters.users.entity.UserEntity;
import app.domain.models.ClinicalRecord;
import app.domain.models.Order;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.domain.models.User;
import app.ports.ClinicalRecordPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class ClinicalRecordAdapter implements ClinicalRecordPort{
	@Autowired
    ClinicalRecordRepository clinicaRecordRepository;

    
    @Override
    public void saveClinicaRecord(ClinicalRecord clinicaRecord) throws Exception {
        ClinicalRecordEntity clinicaRecordEntity = clinicaAdapter(clinicaRecord);
        clinicaRecordRepository.save(clinicaRecordEntity);
        clinicaRecord.setClinicalRecordId(clinicaRecordEntity.getClinicalRecordId());
        clinicaRecord.setDate(clinicaRecordEntity.getDate());
        System.out.println("Historia Clinica Guardada!");
    }  
    
    @Override
    public ClinicalRecord getClinicalRecordByClinicaId(long clinicaId) throws Exception {
        ClinicalRecord clinicalRecord = clinicalAdapter(clinicaRecordRepository.findById(clinicaId));
        if(clinicalRecord == null){throw new Exception("No existe una historia con ese documento");}
        return clinicalRecord;
    }

    private ClinicalRecordEntity clinicaAdapter(ClinicalRecord cliniclaRecord){
        ClinicalRecordEntity clinicalRecordEntity = new ClinicalRecordEntity();
        clinicalRecordEntity.setClinicalRecordId(clinicalRecord.getClinicalRecordId());
        clinicalRecordEntity.setDate(clinicalRecord.getDate());
        clinicalRecordEntity.setDoctorId(clinicalRecord.getDoctorId());
        clinicalRecordEntity.setReason(clinicalRecord.getReason());
        clinicalRecordEntity.setSymptoms(clinicalRecord.getSymptoms());
        clinicalRecordEntity.setDiagnostic(clinicalRecord.getDiagnostic());
        clinicalRecordEntity.setProcedure(clinicalRecord.getProcedure());
        clinicalRecordEntity.setMedicine(clinicalRecord.getMedicine());
        clinicalRecordEntity.setDose(clinicalRecord.getDose());
        clinicalRecordEntity.setOrderId(orderAdapter(clinicalRecord.getOrderId())); 
        clinicalRecordEntity.setVaccationHistory(clinicalRecord.getVaccinationHisotry());
        clinicalRecordEntity.setAllergyMedicines(clinicalRecord.getAllergyMedicines());
        clinicalRecordEntity.setDetailProcedure(clinicalRecord.getDetailProcedure());
        clinicalRecordEntity.setAnnulmentOrder(clinicalRecord.getAnnulmentOrder());
        return clinicalRecordEntity;
    }

    private ClinicalRecord clinicalAdapter(ClinicalRecordEntity clinicalRecordEntity){
        ClinicalRecord clinicalRecord = new ClinicalRecord();
        clinicalRecord.setClinicalRecordId(clinicalRecordEntity.getClinicalRecordId());
        clinicalRecord.setDate(clinicalRecordEntity.getDate());
        clinicalRecord.setDoctorId(clinicalRecordEntity.getDoctorId());
        clinicalRecord.setReason(clinicalRecordEntity.getReason());
        clinicalRecord.setSymptoms(clinicalRecordEntity.getSymptoms());
        clinicalRecord.setDiagnosis(clinicalRecordEntity.getDiagnosis());
        clinicalRecord.setProcedure(clinicalRecordEntity.getProcedure());
        clinicalRecord.setMedicine(clinicalRecordEntity.getMedicine());
        clinicalRecord.setDose(clinicalRecordEntity.getDose());
        clinicalRecord.setOrderId(orderAdapter(clinicalRecordEntity.getOrderId()));
        clinicalRecord.setVaccinationHistory(clinicalRecordEntity.getVaccinationHistory());
        clinicalRecord.setAllergyMedication(clinicalRecordEntity.getAllergyMedication());
        clinicalRecord.setDetailProcedure(clinicalRecordEntity.getDetailProcedure());
        clinicalRecord.setAnnulmentOrder(clinicalRecordEntity.getAnnulmentOrder());
        
        return clinicalRecord;
    }

        private OrderEntity orderAdapter(Order order){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(order.getOrderId());
        orderEntity.setPet(petAdapter(order.getPetId()));
        orderEntity.setPerson(personAdapter(order.getOwnerId()));
        orderEntity.setUser(userAdapter(order.getVeterinaryId()));
        orderEntity.setMedicineName(order.getMedicineName());
        orderEntity.setDateGeneration(order.getDateGeneration());
       return orderEntity;
    }

    private Order orderAdapter(OrderEntity orderEntity){
        Order order = new Order();
        order.setOrderId(orderEntity.getOrderId());
        order.setPet(petAdapter(orderEntity.getPetId()));
        order.setOwner(personAdapter(orderEntity.getPetId()));
        order.setVeterinaryId(userAdapter(orderEntity.getVeterinaryId()));
        order.setMedicineName(orderEntity.getMedicineName());
        order.setDateGeneration(orderEntity.getDateGeneration());
        return order;
    }
        private PetEntity petAdapter(Pet pet){
        PetEntity petEntity = new PetEntity();
        petEntity.setId(pet.getId());
        petEntity.setName(pet.getName());
        petEntity.setAge(pet.getAge());
        petEntity.setSpecies(pet.getSpecies());
        petEntity.setRace(pet.getRace());
        petEntity.setWeight(pet.getWeight());
        return petEntity;
    }

    private PersonEntity personAdapter(Person person){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(person.getName());
        personEntity.setDocument(person.getDocument());
        person.setAge(person.getAge());
        return personEntity;
    }

    private Pet petAdapter(PetEntity petEntity) {
        Pet pet = new Pet();
        pet.setId(petEntity.getId());
        pet.setOwnerId(petEntity.getOwnerId());
        pet.setName(petEntity.getName());
        pet.setAge(petEntity.getAge());
        pet.setSpecies(petEntity.getSpecies());
        pet.setRace(petEntity.getRace());
        pet.setCharacteristics(petEntity.getCharacteristics());
        pet.setWeight(petEntity.getWeight());
        return pet;
    }

    private Person personAdapter(PersonEntity personEntity){
        Person person = new Person();
        person.setName(personEntity.getName());
        person.setDocument(personEntity.getDocument());
        person.setAge(personEntity.getAge());
        return person;
    }

        private User userAdapter(UserEntity userEntity){
        User user = new User();
        user.setPersonDocument(userEntity.getPerson().getDocument());
        user.setPersonName(userEntity.getPerson().getUserName());
        user.setPersonAge(userEntity.getPerson().getAge());
        user.setUserId(userEntity.getUserId());
        user.setUserName(userEntity.getUserName());
        user.setPassword(userEntity.getPassword());
        user.setRole(userEntity.getRole());
        return user;
    }

    private UserEntity userAdapter(User user){
        
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(user.getUserName());
        personEntity.setDocument(user.getDocument());
        personEntity.setAge(user.getAge());

        UserEntity userEntity = new UserEntity();
        userEntity.setPerson(personEntity);
        userEntity.setUserId(user.getUserId());
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        return userEntity;
    }

    @Override
    public List<ClinicalRecord> getAllClinicalRecord() throws Exception {
        List<ClinicalRecordEntity> clinicalRecordEntityList = ClinicalRecordRepository.findAll();
        if(clinicalRecordEntityList.isEmpty()){throw new Exception("No hay historias clinicas");}
        return clinicaAdapterList(clinicalRecordEntityList);
    }
    
    public List<ClinicalRecord> clinicaAdapterList(List<ClinicalRecordEntity> clinicalRecordEntityList){
        List<ClinicalRecord> clinicalRecordList = new ArrayList<>();
        for(ClinicalRecordEntity clinicalRecordEntity : clinicalRecordEntityList){
            clinicalRecordList.add(clinicaAdapter(clinicalRecordEntity));
        }
        return clinicalRecordList;
    }

}
