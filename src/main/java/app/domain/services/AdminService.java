package app.domain.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.models.ClinicalRecord;
import app.domain.models.Order;
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

@NoArgsConstructor
@Getter
@Setter
@Service
public class AdminService {
	 @Autowired
	    private PersonPort personPort;
	    @Autowired
	    private UserPort userPort;
	    @Autowired
	    private PetPort petPort;
	    @Autowired
	    private OrderPort orderPort;
	    @Autowired
	    private ClinicalRecordPort clinicalRecordPort;

	    public void registerVeterinarian(User user)throws Exception{
	        if(personPort.existsPerson(user.getPersonId())){
	            throw new Exception("Ya existe un veterinario con ese nombre");
	        }
	        if(userPort.existUserName(user.getUserName())){
	            throw new Exception("Ya existe un usuario con ese nombre");
	        }
	        personPort.savePerson(user);
	        userPort.saveUser(user);
	    }

	    public void registerSeller(User user)throws Exception{
	        if(personPort.existsPerson(user.getPersonId())){
	            throw new Exception("Ya existe un vendedor con ese nombre");
	        }
	        if(userPort.existUserName(user.getUserName())){
	            throw new Exception("Ya existe un usuario con ese nombre");
	        }
	        personPort.savePerson(user);
	        userPort.saveUser(user);
	        
	    }
	    
	    public void registerOwner(Person person) throws Exception{
	        if(personPort.existsPerson(person.getPersonId())){
	            throw new Exception("Ya existe un cliente con ese documento");
	        }
	        
	        personPort.savePerson(person);
	    }

	    public void registerPet(Pet pet) throws Exception{
	        Person person = personPort.findByPersonDocument(pet.getPersonId().getPersonDocument());
	        if(person == null){
	            throw new Exception("No existe una persona con ese documetno");
	        }
	        pet.setOwnerId(person);
	        petPort.savePet(pet);
	    }

	    public void registerOrder(Order order)throws Exception{
	        Pet pet = petPort.findByPetId(order.getPet().getPetId());
	        Person person = personPort.findByPersonDocument(order.getOwner().getPersonDocument());
	        User user = userPort.findByPersonDocument(order.getVeterinarian().getPersonDocument());
	        if(pet == null){
	            throw new Exception("No existe una mascota con ese documento");
	        }
	        if(person == null){
	            throw new Exception("No existe un cliente con ese documetno");
	        }
	        if(user == null){
	            throw new Exception("No existe un veterinario con ese documetno");
	        }
	        order.setPetId(pet);
	        order.setOwnerId(person);
	        order.setVeterinaryId(user);
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
	        clinicalRecord.setOrder(order);
	        clinicalRecordPort.saveClinicaRecord(clinicaRecord);
	    }

	  public ClinicalRecord getClinicalRecordByClinicaId(long clinicaId) throws Exception{
	        ClinicalRecord clinicaRecord = clinicalRecordPort.getClinicaRecordByClinicaId(clinicaId);
	        if(clinicaRecord == null){
	            throw new Exception("No existe una historia clinica con ese ID");
	        }
	        return clinicaRecord;
	    }

	   public  List<Order> getAllOrdenes() throws Exception {
	        return orderPort.getAllOrder();
	    }

	    public List<ClinicalRecord> getAllClinicaRecords() throws Exception {
	        return clinicalRecordPort.getAllClinicaRecord();
	    }
	}
