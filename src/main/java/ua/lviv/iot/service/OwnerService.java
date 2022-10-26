package ua.lviv.iot.service;

import java.util.List;

import ua.lviv.iot.model.Owner;

public interface OwnerService extends GeneralService<Owner, Long>{

    List<Owner>findOwnersByFirstName(String firstName);
    List<Owner>findOwnersByLastName(String lastName);
    
}
