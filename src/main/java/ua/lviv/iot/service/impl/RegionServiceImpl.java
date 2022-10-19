package ua.lviv.iot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.RegionDao;
import ua.lviv.iot.dao.impl.RegionDaoImpl;
import ua.lviv.iot.model.Region;
@Service
public class RegionServiceImpl implements RegionDao {

   private RegionDaoImpl dao;

    @Autowired
    public RegionServiceImpl(RegionDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<Region> findAll() {
        return dao.findAll();
    }


    @Override
    public int save(Region entity) {
        return dao.save(entity);
    }

    @Override
    public int update(Region entity, String id) {
        return dao.update(entity, id);
    }

    @Override
    public int deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public Optional<Region> findRegionByName(String name) {
        return dao.findRegionByName(name);
    }

}
