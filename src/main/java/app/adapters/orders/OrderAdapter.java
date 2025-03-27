package app.adapters.orders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.adapters.order.entity.OrderEntity;
import app.adapters.order.repository.OrderRepository;
import app.adapters.person.entity.PersonEntity;
import app.adapters.pet.entity.PetEntity;
import app.adapters.users.entity.UserEntity;
import app.domain.models.Order;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.domain.models.User;
import app.ports.OrderPort;

public class OrderAdapter implements OrderPort{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        OrderEntity orderEntity = orderAdapter(order);
        orderRepository.save(orderEntity);
        order.setOrderId(orderEntity.getOrderId());
        order.setDateGeneration(orderEntity.getDateGeneration());
        System.out.println("Orden Creada");
    }

    @Override
    public Order findByOrderId(long orderId) throws Exception {
        Order order = orderAdapter(orderRepository.findById(orderId));
        if(order == null){throw new Exception("No existe una orden con ese ID");}
        return order;
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

    private Order ordenAdapter(OrderEntity orderEntity){
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
        petEntity.setOwnerId(pet.getOwnerId());
        petEntity.setAge(pet.getAge());
        petEntity.setSpecies(pet.getSpecies());
        petEntity.setRace(pet.getRace());
        petEntity.setCharacteristics(pet.getCharacteristics());
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
        pet.setName(petEntity.getName());
        pet.setOwnerId(petEntity.getOwnerId());
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
        user.setPersonId(userEntity.getPersonId());
        user.setUserId(userEntity.getUserId());
        user.setUserName(userEntity.getUserName());
        user.setPassword(userEntity.getPassword());
        user.setRole(userEntity.getRole());
        return user;
    }

    private UserEntity userAdapter(User user){
       
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(user.getPersonName());
        personEntity.setDocument(user.getPersonDocument());
        personEntity.setAge(user.getPersonAge());

        UserEntity userEntity = new UserEntity();
        userEntity.setPerson(personEntity);
        userEntity.setUserId(user.getUserId());
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        return userEntity;
    }

    @Override
    public List<Order> getAllOrder() throws Exception {
        List<OrderEntity> orderEntityList = orderRepository.findAll();
        if(orderEntityList.isEmpty()){throw new Exception("No hay ordenes en la base de datos");}
        return orderAdapterList(orderEntityList);
    }

    public List<Order> orderAdapterList(List<OrderEntity> orderEntityList){
        List<Order> orderList = new ArrayList<>();
        for(OrderEntity orderEntity : orderEntityList){
            orderList.add(orderAdapter(orderEntity));
        }
        return orderList;
  
	

    }
}
