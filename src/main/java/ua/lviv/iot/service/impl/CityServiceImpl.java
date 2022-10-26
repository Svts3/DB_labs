package ua.lviv.iot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.CityDao;
import ua.lviv.iot.dao.impl.CityDaoImpl;
import ua.lviv.iot.model.City;
@Service
public class CityServiceImpl implements CityDao {

    private CityDaoImpl dao;
    
    @Autowired
    public CityServiceImpl(CityDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<City> findAll() {
        return dao.findAll();
    }


    @Override
    public int save(City entity) {
        // TODO Auto-generated method stub
        return dao.save(entity);
    }

    @Override
    public int update(City entity, String id) {
        return dao.update(entity, id);
    }

    @Override
    public int deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public Optional<City> findCityByName(String name) {
        return dao.findCityByName(name);
    }

}
