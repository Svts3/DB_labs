package ua.lviv.iot.dao;

import java.util.List;

import ua.lviv.iot.model.Owner;

public interface OwnerDao extends GeneralDao<Owner, Long>{

    List<Owner>findOwnersByFirstName(String firstName);
    List<Owner>findOwnersByLastName(String lastName);
    
}
