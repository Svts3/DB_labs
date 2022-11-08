package ua.lviv.iot.service;

import java.util.List;

import ua.lviv.iot.model.Owner;
import ua.lviv.iot.model.Watch;

public interface OwnerService extends GeneralService<Owner, Long>{

    List<Owner> findByFirstName(String firstName);
    
    List<Owner> findByLastName(String lastName);
    
    List<Watch>findAllWatchesByOwnerId(Long ownerId);
    
    void ownerInsertion();
    
    void createDatabasesForEachOwner();
}
