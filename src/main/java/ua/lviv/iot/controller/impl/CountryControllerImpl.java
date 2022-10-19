package ua.lviv.iot.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.CountryDao;
import ua.lviv.iot.dao.impl.ContryDaoImpl;
import ua.lviv.iot.model.Country;

@Controller
public class CountryControllerImpl implements CountryDao {

    private ContryDaoImpl service;

    @Autowired
    public CountryControllerImpl(ContryDaoImpl service) {
        this.service = service;
    }

    @Override
    public List<Country> findAll() {
        return service.findAll();
    }
    @Override
    public int save(Country entity) {
        return service.save(entity);
    }

    @Override
    public int update(Country entity, String id) {
        return service.update(entity, id);
    }

    @Override
    public int deleteById(String id) {
        return service.deleteById(id);
    }

    @Override
    public Optional<Country> findCountryByName(String name) {
        return service.findCountryByName(name);
    }

}
