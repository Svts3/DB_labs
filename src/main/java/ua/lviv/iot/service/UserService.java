package ua.lviv.iot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.lviv.iot.model.User;
@Service
public interface UserService extends GeneralService<User, Long> {
    
    List<User> findByFirstName(String firstName);
        
    List<User> findByLastName(String lastName);
}
