package ua.lviv.iot.controller;

import java.util.List;
import java.util.Optional;

public interface GeneralController<T, ID> {

    List<T>findAll();
    
    Optional<T> findById(ID id);
    
    int save(T entity);

    int update(T entity, ID id);
    
    int deleteById(ID id);
    
}
