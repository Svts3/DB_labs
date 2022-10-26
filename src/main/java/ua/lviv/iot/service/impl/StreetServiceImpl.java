package ua.lviv.iot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.StreetDao;
import ua.lviv.iot.dao.impl.StreetDaoImpl;
import ua.lviv.iot.model.Street;
@Service
public class StreetServiceImpl implements StreetDao {

    private StreetDaoImpl dao;

    @Autowired
    public StreetServiceImpl(StreetDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<Street> findAll() {
        return dao.findAll();
    }


    @Override
    public int save(Street entity) {
        return dao.save(entity);
    }

    @Override
    public int update(Street entity, String id) {
        return dao.update(entity, id);
    }

    @Override
    public int deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public Optional<Street> findStreetByName(String name) {

        return dao.findStreetByName(name);
    }

}
