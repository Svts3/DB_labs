package ua.lviv.iot.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.WatchLocationDao;
import ua.lviv.iot.dao.impl.WatchLocationDaoImpl;
import ua.lviv.iot.model.WatchLocation;
@Controller
public class WatchLocationControllerImpl implements WatchLocationDao {

    private WatchLocationDaoImpl service;

    @Autowired
    public WatchLocationControllerImpl(WatchLocationDaoImpl service) {
        this.service = service;
    }

    @Override
    public List<WatchLocation> findAll() {
        return service.findAll();
    }

    public Optional<WatchLocation> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public int save(WatchLocation entity) {
        return service.save(entity);
    }

    @Override
    public int update(WatchLocation entity, Long id) {
        return service.update(entity, id);
    }

    @Override
    public int deleteById(Long id) {
        return service.deleteById(id);
    }

}
