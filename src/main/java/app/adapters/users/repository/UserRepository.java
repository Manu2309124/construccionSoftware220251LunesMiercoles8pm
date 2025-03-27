package app.adapters.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.adapters.person.entity.PersonEntity;
import app.adapters.users.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByUserName(String userName);

    UserEntity findByUserName(String userName);

    UserEntity findByPerson(PersonEntity person);
}
