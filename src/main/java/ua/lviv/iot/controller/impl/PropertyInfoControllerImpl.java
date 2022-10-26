package ua.lviv.iot.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.PropertyInfoDao;
import ua.lviv.iot.dao.impl.PropertyInfoDaoImpl;
import ua.lviv.iot.model.PropertyInfo;

@Controller
public class PropertyInfoControllerImpl implements PropertyInfoDao {

    private PropertyInfoDaoImpl service;
    
    @Autowired
    public PropertyInfoControllerImpl(PropertyInfoDaoImpl service) {
        this.service = service;
    }

    @Override
    public List<PropertyInfo> findAll() {
        return service.findAll();
    }

    public Optional<PropertyInfo> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public int save(PropertyInfo entity) {
        return service.save(entity);
    }

    @Override
    public int update(PropertyInfo entity, Long id) {
        return service.update(entity, id);
    }

    @Override
    public int deleteById(Long id) {
        return service.deleteById(id);
    }

}
