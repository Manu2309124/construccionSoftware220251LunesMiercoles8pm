package app.domain.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.order.repository.Order;
import app.domain.models.ClinicalRecord;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.domain.models.User;
import app.ports.ClinicalRecordPort;
import app.ports.OrderPort;
import app.ports.PersonPort;
import app.ports.PetPort;
import app.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Service
public class VeterinaryService {
	  @Autowired
	    private ClinicalRecordPort clinicalRecordPort;
	    @Autowired
	    private PetPort petPort;
	    @Autowired
	    private PersonPort personPort;
	    @Autowired
	    private UserPort userPort;
	    @Autowired
	    private OrderPort orderPort;

	    public void registerPet(Pet pet) throws Exception{
	        Person person = personPort.findByPersonDocument(pet.getPersonId().getPersonDocument());
	        if(person == null){
	            throw new Exception("No existe una persona con ese documetno");
	        }
	        
	        pet.setPersonId(person);
	        petPort.savePet(pet);
	    }
	    
	    public void registerClient(Person person)throws Exception{
	        if(personPort.existsPerson(person.getPersonDocument())){
	            throw new Exception("Ya existe una Ciente con esa cedula");
	        }
	        personPort.savePerson(person);
	        System.out.println("Cliente Creado");
	    }

	    public void registerOrder(Order order) throws Exception{
	        Pet pet = petPort.findByPetId(order.getPet().getPetId());
	        Person person = personPort.findByPersonDocument(order.getOwner().getPersonDocument());
	        User user = userPort.findByPersonDocument(order.getVeterinarian().getPersonDocument());
	        if(pet == null){
	            throw new Exception("No existe mascota con ese ID");
	        }
	        if(person == null){
	            throw new Exception("No existe cliente con esa cedula"); 
	        }
	        if(user == null){
	            throw new Exception("No existe veterinario con esa cedula");
	        }
	        order.setPet(pet);
	        order.setOwner(person);
	        order.setVeterinarian(user);
	        orderPort.saveOrder(order);
	    }

	    public Order getOrderByOrderId(long orderId) throws Exception{
	        Order order = orderPort.findByOrderId(orderId);
	        if(order == null){
	            throw new Exception("No existe una orden con ese ID");
	        }
	        return order;
	    }

	    public void registerClinicaRecord(ClinicalRecord clinicaRecord) throws Exception {
	        Order order = orderPort.findByOrderId(clinicaRecord.getOrder().getOrderId());
	        if(order == null){
	            throw new Exception("No existe una orden con ese documento");
	        }
	        clinicaRecord.setOrder(order);
	        clinicalRecordPort.saveClinicaRecord(clinicaRecord);
	    }

	    public void cancelOrder(Order order)throws Exception {
	        if(order == null){
	            throw new Exception("No existe una orden con ese ID");
	        }
	        order.setOrderStatus("Anulada");
	        orderPort.saveOrder(order);
	    }

	    public ClinicalRecord getClinicalRecordByClinicaId(long clinicaId) throws Exception{
	        ClinicalRecord clinicaRecord = clinicalRecordPort.getClinicalRecordByClinicaId(clinicaId);
	        if(clinicaRecord == null){
	            throw new Exception("No existe una historia clinica con ese ID");
	        }
	        return clinicaRecord;
	    }

	    public  List<Order> getAllOrdenes() throws Exception {
	        return orderPort.getAllOrder();
	    }

	    public List<ClinicalRecord> getAllClinicaRecords() throws Exception {
	        return clinicalRecordPort.getAllClinicalRecord();
	    }

	    public void updateClinicaRecord(ClinicalRecord clinicaRecord)throws Exception {
	        clinicalRecordPort.saveClinicaRecord(clinicaRecord);
	    }

	    public void updateOrder(Order order)throws Exception {
	        orderPort.saveOrder(order);
	    }

	}



    