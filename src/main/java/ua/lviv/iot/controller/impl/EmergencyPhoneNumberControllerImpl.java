package ua.lviv.iot.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.EmergencyPhoneNumberDao;
import ua.lviv.iot.dao.impl.EmergencyPhoneNumberDaoImpl;
import ua.lviv.iot.model.EmergencyPhoneNumber;

@Controller
public class EmergencyPhoneNumberControllerImpl implements EmergencyPhoneNumberDao {

    private EmergencyPhoneNumberDaoImpl service;
    
    @Autowired
    public EmergencyPhoneNumberControllerImpl(EmergencyPhoneNumberDaoImpl service) {
        this.service = service;
    }

    @Override
    public List<EmergencyPhoneNumber> findAll() {
        return service.findAll();
    }

    public Optional<EmergencyPhoneNumber> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public int save(EmergencyPhoneNumber entity) {
        return service.save(entity);
    }

    @Override
    public int update(EmergencyPhoneNumber entity, Long id) {
        return service.update(entity, id);
    }

    @Override
    public int deleteById(Long id) {
        return service.deleteById(id);
    }

}
