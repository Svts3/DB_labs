package ua.lviv.iot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.OwnerDao;
import ua.lviv.iot.dao.impl.OwnerDaoImpl;
import ua.lviv.iot.model.Owner;

@Service
public class OwnerServiceImpl implements OwnerDao {

    private OwnerDaoImpl dao;
    
    @Autowired
    public OwnerServiceImpl(OwnerDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<Owner> findAll() {

        return dao.findAll();
    }

    public Optional<Owner> findById(Long id) {
        return dao.findById(id);

    }

    @Override
    public int save(Owner entity) {

        return dao.save(entity);

    }

    @Override
    public int update(Owner entity, Long id) {
        return dao.update(entity, id);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<Owner> findOwnersByFirstName(String firstName) {
        return dao.findOwnersByFirstName(firstName);
    }

    @Override
    public List<Owner> findOwnersByLastName(String lastName) {
        return dao.findOwnersByLastName(lastName);
    }

}
