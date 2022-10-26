package ua.lviv.iot.controller;

import java.util.List;

import ua.lviv.iot.model.Owner;

public interface OwnerController extends GeneralController<Owner, Long>{

    List<Owner>findOwnersByFirstName(String firstName);
    List<Owner>findOwnersByLastName(String lastName);
    
}
