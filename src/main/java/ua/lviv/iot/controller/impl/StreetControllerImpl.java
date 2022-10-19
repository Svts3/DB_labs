package ua.lviv.iot.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.StreetDao;
import ua.lviv.iot.dao.impl.StreetDaoImpl;
import ua.lviv.iot.model.Street;
@Controller
public class StreetControllerImpl implements StreetDao {

    private StreetDaoImpl service;

    @Autowired
    public StreetControllerImpl(StreetDaoImpl service) {
        this.service = service;
    }

    @Override
    public List<Street> findAll() {
        return service.findAll();
    }

    public Optional<Street> findById(String id) {
        return null;
    }

    @Override
    public int save(Street entity) {
        return service.save(entity);
    }

    @Override
    public int update(Street entity, String id) {
        return service.update(entity, id);
    }

    @Override
    public int deleteById(String id) {
        return service.deleteById(id);
    }

    @Override
    public Optional<Street> findStreetByName(String name) {

        return service.findStreetByName(name);
    }

}
