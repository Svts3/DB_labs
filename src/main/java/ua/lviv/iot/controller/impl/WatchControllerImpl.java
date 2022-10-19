package ua.lviv.iot.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.WatchDao;
import ua.lviv.iot.dao.impl.WatchDaoImpl;
import ua.lviv.iot.model.Watch;
@Controller
public class WatchControllerImpl implements WatchDao {

    private WatchDaoImpl service;
    
    @Autowired
    public WatchControllerImpl(WatchDaoImpl service) {
        this.service = service;
    }

    @Override
    public List<Watch> findAll() {

        return service.findAll();
    }

    public Optional<Watch> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public int save(Watch entity) {
        return service.save(entity);
    }

    @Override
    public int update(Watch entity, String serialNumber) {
        return service.update(entity, serialNumber);
    }

    @Override
    public int deleteById(String id) {
        return service.deleteById(id);
    }

    @Override
    public Optional<Watch> findWatchBySerialNumber(String serialNumber) {
        return service.findWatchBySerialNumber(serialNumber);
    }

}
