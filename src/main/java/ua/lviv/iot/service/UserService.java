package ua.lviv.iot.service;

import java.util.List;

import ua.lviv.iot.model.User;

public interface UserService extends GeneralService<User, Long> {
    
    List<User> findByFirstName(String firstName);
        
    List<User> findByLastName(String lastName);
}
