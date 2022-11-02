package ua.lviv.iot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.lviv.iot.model.Owner;
import ua.lviv.iot.model.Watch;
@Service
public interface OwnerService extends GeneralService<Owner, Long>{

    List<Owner> findByFirstName(String firstName);
    
    List<Owner> findByLastName(String lastName);
    
    List<Watch>findAllWatchesByOwnerId(Long ownerId);
}
