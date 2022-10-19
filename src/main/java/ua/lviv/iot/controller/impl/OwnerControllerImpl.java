package ua.lviv.iot.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.OwnerDao;
import ua.lviv.iot.dao.impl.OwnerDaoImpl;
import ua.lviv.iot.model.Owner;

@Controller
public class OwnerControllerImpl implements OwnerDao {

    private OwnerDaoImpl service;
    
    @Autowired
    public OwnerControllerImpl(OwnerDaoImpl service) {
        this.service = service;
    }

    @Override
    public List<Owner> findAll() {

        return service.findAll();
    }

    public Optional<Owner> findById(Long id) {
        return service.findById(id);

    }

    @Override
    public int save(Owner entity) {

        return service.save(entity);

    }

    @Override
    public int update(Owner entity, Long id) {
        return service.update(entity, id);
    }

    @Override
    public int deleteById(Long id) {
        return service.deleteById(id);
    }

    @Override
    public List<Owner> findOwnersByFirstName(String firstName) {
        return service.findOwnersByFirstName(firstName);
    }

    @Override
    public List<Owner> findOwnersByLastName(String lastName) {
        return service.findOwnersByLastName(lastName);
    }

}
