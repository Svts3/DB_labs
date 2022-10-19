package ua.lviv.iot.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.CityDao;
import ua.lviv.iot.dao.impl.CityDaoImpl;
import ua.lviv.iot.model.City;
@Controller
public class CityControllerImpl implements CityDao {

    private CityDaoImpl service;
    
    @Autowired
    public CityControllerImpl(CityDaoImpl service) {
        this.service = service;
    }

    @Override
    public List<City> findAll() {
        return service.findAll();
    }


    @Override
    public int save(City entity) {
        // TODO Auto-generated method stub
        return service.save(entity);
    }

    @Override
    public int update(City entity, String id) {
        return service.update(entity, id);
    }

    @Override
    public int deleteById(String id) {
        return service.deleteById(id);
    }

    @Override
    public Optional<City> findCityByName(String name) {
        return service.findCityByName(name);
    }

}
