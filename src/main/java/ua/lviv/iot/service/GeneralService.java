package ua.lviv.iot.service;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T, ID> {

    List<T>findAll();
    
    Optional<T> findById(ID id);
    
    int save(T entity);

    int update(T entity, ID id);
    
    int deleteById(ID id);
    
}
