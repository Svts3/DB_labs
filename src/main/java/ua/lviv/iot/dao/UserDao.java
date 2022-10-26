package ua.lviv.iot.dao;

import java.util.List;

import ua.lviv.iot.model.User;

public interface UserDao extends GeneralDao<User, Long>{

    List<User>findUsersByFirstName(String firstName);
    List<User>findUsersByLastName(String lastName);
    
}
