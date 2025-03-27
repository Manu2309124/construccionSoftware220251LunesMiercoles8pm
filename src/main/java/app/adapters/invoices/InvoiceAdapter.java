package app.adapters.invoices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.invoice.entity.InvoiceEntity;
import app.adapters.invoice.repository.InvoiceRepository;
import app.adapters.order.entity.OrderEntity;
import app.adapters.person.entity.PersonEntity;
import app.adapters.pet.entity.PetEntity;
import app.adapters.users.entity.UserEntity;
import app.domain.models.Invoice;
import app.domain.models.Order;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.domain.models.User;
import app.ports.InvoicePort;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class InvoiceAdapter  implements InvoicePort{
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public void saveInvoice(Invoice invoice) {
        InvoiceEntity invoiceEntity = invoiceAdapter(invoice);
        invoiceRepository.save(invoiceEntity);
        invoice.setInvoiceId(invoiceEntity.getInvoiceId());
        invoice.setDate(invoiceEntity.getDate());
    }

    @Override
    public Invoice findByInvoiceId(long invoiceId) throws Exception{
        InvoiceEntity invoiceEntity = invoiceRepository.findByInvoiceId(invoiceId);
        if(invoiceEntity == null){
            throw new Exception("No existe una fatura con ese Id");
        }
        return invoiceAdapter(invoiceEntity);
    }

    private InvoiceEntity invoiceAdapter(Invoice invoice){
        InvoiceEntity invoicedEntity = new InvoiceEntity();
        invoiceEntity.setAmount(invoice.getAmount());
        invoiceEntity.setOrder(orderAdapter(invoice.getOrderId()));
        invoiceEntity.setInvoiceId(invoice.getInvoiceId());
        invoiceEntity.setProduct(invoice.getProductName());
        invoiceEntity.setAmount(invoice.getAmount());
        invoiceEntity.setMedicationQuantity(invoice.getMedicationQuantity());
        invoiceEntity.setDate(invoice.getDate());    
        return invoiceEntity;
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

    private PersonEntity personAdapter(User user){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(user.getUserName());
        personEntity.setDocument(user.getDocument());
        user.setAge(user.getAge());
        return personEntity;
    }

    private OrderEntity ordenAdapter(Order order){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setPerson(personAdapter(order.getOwnerId()));
        orderEntity.setPet(petAdapter(order.getPetId()));
        orderEntity.setUser(userAdapter(order.getVeterinaryId()));
        orderEntity.setOrderId(order.getOrderId());
        orderEntity.setMedicineName(order.getMedicineName());
        orderEntity.setMedicationDosis(order.getMedicationDosis());
        orderEntity.setDate(order.getDate());
        orderEntity.setOrderId(order.getOrderId());
        return orderEntity;
    }

    private Pet petAdapter(PetEntity petEntity) {
        Pet pet = new Pet();
        pet.setName(petEntity.getName());
        pet.setAge(petEntity.getAge());
        pet.setSpecies(petEntity.getSpecies());
        pet.setRace(petEntity.getRace());
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

    private Order orderAdapter(OrderEntity orderEntity){
        Order order = new Order();
        order.setOrderId(orderEntity.getOrderId());
        order.setOwner(personAdapter(orderEntity.getPetId()));
        order.setPet(petAdapter(orderEntity.getPetId()));
        order.setVeterinarian(userAdapter(orderEntity.getUser()));
        order.setMedicineName(orderEntity.getMedicineName());
        order.setMedicationDosis(orderEntity.getMedicationDosis());
        order.setDate(orderEntity.getDate());
        order.setOrderId(orderEntity.getOrderId());
        return order;
    }



    private Invoice invoiceAdapter(InvoiceEntity invoiceEntity){
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(invoiceEntity.getInvoiceId());
        invoice.setOrder(orderAdapter(invoiceEntity.getOrderId()));
        invoice.setProductName(invoiceEntity.getProductName());
        invoice.setAmount(invoiceEntity.getAmount());
        invoice.setMedicationQuantity(invoiceEntity.getMedicationQuantity());
        invoice.setDate(invoiceEntity.getDate());
        return invoice;
    }
    

    private User userAdapter(UserEntity userEntity){
        User user = new User();
        user.setUserId(userEntity.getUserId());
        user.setPersonName(userEntity.getPerson().getUserName());
        user.setPersonDocument(userEntity.getPerson().getDocument());
        user.setPersonAge(userEntity.getPerson().getAge());
        user.setUserName(userEntity.getUserName());
        return user;
    }

    private UserEntity userAdapter(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(user.getUserId());
        userEntity.setPerson(personAdapter(user));
        return userEntity;
    }

    @Override
    public List<Invoice> getAllInvoice() throws Exception {
        List<InvoiceEntity> invoiceEntityList = invoiceRepository.findAll();
        if(invoiceEntityList.isEmpty()){
            throw new Exception("No hay facturas");
        }
        return invoiceAdapterList(invoiceEntityList);
    }

    public List<Invoice> invoiceAdapterList(List<InvoiceEntity> invoiceEntityList)throws Exception{
        List<Invoice> invoiceList = new ArrayList<>();
        for(InvoiceEntity invoiceEntity : invoiceEntityList){
            invoiceList.add(invoiceAdapter(invoiceEntity));
        }
        return invoiceList;
    }




}
