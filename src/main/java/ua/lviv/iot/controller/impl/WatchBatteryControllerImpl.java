package ua.lviv.iot.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.WatchBatteryDao;
import ua.lviv.iot.dao.impl.WatchBatteryDaoImpl;
import ua.lviv.iot.model.WatchBattery;

@Controller
public class WatchBatteryControllerImpl implements WatchBatteryDao {

    private WatchBatteryDaoImpl service;

    @Autowired
    public WatchBatteryControllerImpl(WatchBatteryDaoImpl service) {
        this.service = service;
    }

    @Override
    public List<WatchBattery> findAll() {
        return service.findAll();
    }

    public Optional<WatchBattery> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public int save(WatchBattery entity) {
        return service.save(entity);
    }

    @Override
    public int update(WatchBattery entity, Long id) {
        return service.update(entity, id);
    }

    @Override
    public int deleteById(Long id) {
        return service.deleteById(id);
    }

}
