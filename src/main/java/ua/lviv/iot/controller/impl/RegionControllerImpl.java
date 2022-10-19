package ua.lviv.iot.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.RegionDao;
import ua.lviv.iot.dao.impl.RegionDaoImpl;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.model.Region;
@Controller
public class RegionControllerImpl implements RegionDao {

   private RegionDaoImpl service;

    @Autowired
    public RegionControllerImpl(RegionDaoImpl service) {
        this.service = service;
    }

    @Override
    public List<Region> findAll() {
        return service.findAll();
    }


    @Override
    public int save(Region entity) {
        return service.save(entity);
    }

    @Override
    public int update(Region entity, String id) {
        return service.update(entity, id);
    }

    @Override
    public int deleteById(String id) {
        return service.deleteById(id);
    }

    @Override
    public Optional<Region> findRegionByName(String name) {
        return service.findRegionByName(name);
    }

}
