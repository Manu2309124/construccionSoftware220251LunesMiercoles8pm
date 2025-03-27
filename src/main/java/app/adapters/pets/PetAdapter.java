package app.adapters.pets;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.person.entity.PersonEntity;
import app.adapters.pet.entity.PetEntity;
import app.adapters.pet.repository.PetRepository;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.ports.PetPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class PetAdapter implements PetPort{
    @Autowired
    private PetRepository petRepository;

    @Override
    public void savePet(Pet pet) {
        PetEntity petEntity = petAdapter(pet);
        petRepository.save(petEntity);
        pet.setId(petEntity.getId());
        System.out.println("Mascota Creada.");
    }

    @Override
    public Pet findByOwnerDocument(Long personDocument)throws Exception{
        PetEntity petEntity = petRepository.findByOwnerId(personDocument);
        if(petEntity == null){
            throw new Exception("No existe un Cliente con esa cedula");
        }
        return petAdapter(petEntity);
    }


    @Override
    public Pet findByPetId(Long petId)throws Exception {
       PetEntity petEntity = petRepository.findById(petId);
       if(petEntity == null){
        throw new Exception("No existe un Cliente con esa cedula");
    }
       return petAdapter(petEntity);
    }

    private PetEntity petAdapter(Pet pet){
        PetEntity petEntity = new PetEntity();
        petEntity.setOwner(personAdapter(pet.getPersonId()));
        petEntity.setId(pet.getId());
        petEntity.setName(pet.getName());
        petEntity.setAge(pet.getAge());
        petEntity.setSpecies(pet.getSpecies());
        petEntity.setRace(pet.getRace());
        pet.setCharacteristics(petEntity.getCharacteristics());
        petEntity.setWeight(pet.getWeight());
        return petEntity;
    }
    private PersonEntity personAdapter(Person person){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(person.getName());
        personEntity.setDocument(person.getDocument());
        personEntity.setAge(person.getAge());
        return personEntity;
    }

    private Person personAdapter(PersonEntity personEntity){
        Person person = new Person();
        person.setName(personEntity.getName());
        person.setDocument(personEntity.getDocument());
        person.setAge(personEntity.getAge());
        return person;
    }

    private Pet petAdapter(PetEntity petEntity){
        Pet pet = new Pet();
        pet.setPersonId(personAdapter(petEntity.getOwnerId()));
        pet.setName(petEntity.getName());
        pet.setAge(petEntity.getAge());
        pet.setId(petEntity.getId());
        pet.setSpecies(petEntity.getSpecies());
        pet.setRace(petEntity.getRace());
        pet.setCharacteristics(petEntity.getCharacteristics());
        pet.setWeight(petEntity.getWeight());
        return pet;
    }
}
