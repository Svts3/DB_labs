package ua.lviv.iot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.WatchDao;
import ua.lviv.iot.dao.impl.WatchDaoImpl;
import ua.lviv.iot.model.Watch;
@Service
public class WatchServiceImpl implements WatchDao {

    private WatchDaoImpl dao;
    
    @Autowired
    public WatchServiceImpl(WatchDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<Watch> findAll() {

        return dao.findAll();
    }

    public Optional<Watch> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public int save(Watch entity) {
        return dao.save(entity);
    }

    @Override
    public int update(Watch entity, String id) {
        return dao.update(entity, id);
    }

    @Override
    public int deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public Optional<Watch> findWatchBySerialNumber(String serialNumber) {
        return dao.findWatchBySerialNumber(serialNumber);
    }

}
