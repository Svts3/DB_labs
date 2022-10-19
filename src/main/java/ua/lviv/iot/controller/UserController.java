package ua.lviv.iot.controller;

import java.util.List;

import ua.lviv.iot.model.User;

public interface UserController extends GeneralController<User, Long>{

    List<User>findUsersByFirstName(String firstName);
    List<User>findUsersByLastName(String lastName);
    
}
