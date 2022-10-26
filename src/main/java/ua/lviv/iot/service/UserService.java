package ua.lviv.iot.service;

import java.util.List;

import ua.lviv.iot.model.User;

public interface UserService extends GeneralService<User, Long>{

    List<User>findUsersByFirstName(String firstName);
    List<User>findUsersByLastName(String lastName);
    
}
