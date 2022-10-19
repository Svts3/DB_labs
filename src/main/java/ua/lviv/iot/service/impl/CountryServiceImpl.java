package ua.lviv.iot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.CountryDao;
import ua.lviv.iot.dao.impl.ContryDaoImpl;
import ua.lviv.iot.model.Country;

@Service
public class CountryServiceImpl implements CountryDao {

    private ContryDaoImpl dao;

    @Autowired
    public CountryServiceImpl(ContryDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<Country> findAll() {
        return dao.findAll();
    }


    @Override
    public int save(Country entity) {
        return dao.save(entity);
    }

    @Override
    public int update(Country entity, String id) {
        return dao.update(entity, id);
    }

    @Override
    public int deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public Optional<Country> findCountryByName(String name) {
        return dao.findCountryByName(name);
    }

}
