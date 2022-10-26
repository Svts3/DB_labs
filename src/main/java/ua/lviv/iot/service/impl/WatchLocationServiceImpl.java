package ua.lviv.iot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.WatchLocationDao;
import ua.lviv.iot.dao.impl.WatchLocationDaoImpl;
import ua.lviv.iot.model.WatchLocation;
@Service
public class WatchLocationServiceImpl implements WatchLocationDao {

    private WatchLocationDaoImpl dao;

    @Autowired
    public WatchLocationServiceImpl(WatchLocationDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<WatchLocation> findAll() {
        return dao.findAll();
    }

    public Optional<WatchLocation> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public int save(WatchLocation entity) {
        return dao.save(entity);
    }

    @Override
    public int update(WatchLocation entity, Long id) {
        return dao.update(entity, id);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

}
