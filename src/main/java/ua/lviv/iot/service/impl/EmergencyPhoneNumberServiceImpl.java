package ua.lviv.iot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.EmergencyPhoneNumberDao;
import ua.lviv.iot.dao.impl.EmergencyPhoneNumberDaoImpl;
import ua.lviv.iot.model.EmergencyPhoneNumber;

@Service
public class EmergencyPhoneNumberServiceImpl implements EmergencyPhoneNumberDao {

    private EmergencyPhoneNumberDaoImpl dao;
    
    @Autowired
    public EmergencyPhoneNumberServiceImpl(EmergencyPhoneNumberDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<EmergencyPhoneNumber> findAll() {
        return dao.findAll();
    }

    public Optional<EmergencyPhoneNumber> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public int save(EmergencyPhoneNumber entity) {
        return dao.save(entity);
    }

    @Override
    public int update(EmergencyPhoneNumber entity, Long id) {
        return dao.update(entity, id);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

}
