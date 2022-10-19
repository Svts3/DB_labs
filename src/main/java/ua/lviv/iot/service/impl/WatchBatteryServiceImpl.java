package ua.lviv.iot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.WatchBatteryDao;
import ua.lviv.iot.dao.impl.WatchBatteryDaoImpl;
import ua.lviv.iot.model.WatchBattery;

@Service
public class WatchBatteryServiceImpl implements WatchBatteryDao {

    private WatchBatteryDaoImpl dao;

    @Autowired
    public WatchBatteryServiceImpl(WatchBatteryDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<WatchBattery> findAll() {
        return dao.findAll();
    }

    public Optional<WatchBattery> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public int save(WatchBattery entity) {
        return dao.save(entity);
    }

    @Override
    public int update(WatchBattery entity, Long id) {
        return dao.update(entity, id);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

}
