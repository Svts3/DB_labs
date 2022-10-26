package ua.lviv.iot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.PropertyInfoDao;
import ua.lviv.iot.dao.impl.PropertyInfoDaoImpl;
import ua.lviv.iot.model.PropertyInfo;

@Service
public class PropertyInfoServiceImpl implements PropertyInfoDao {

    private PropertyInfoDaoImpl dao;
    
    @Autowired
    public PropertyInfoServiceImpl(PropertyInfoDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<PropertyInfo> findAll() {
        return dao.findAll();
    }

    public Optional<PropertyInfo> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public int save(PropertyInfo entity) {
        return dao.save(entity);
    }

    @Override
    public int update(PropertyInfo entity, Long id) {
        return dao.update(entity, id);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

}
