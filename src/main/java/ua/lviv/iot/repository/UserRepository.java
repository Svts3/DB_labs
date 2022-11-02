package ua.lviv.iot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);
}
