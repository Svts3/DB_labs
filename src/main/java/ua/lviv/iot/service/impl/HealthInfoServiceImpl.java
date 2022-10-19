package ua.lviv.iot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.HealthInfoDao;
import ua.lviv.iot.dao.impl.HealthInfoDaoImpl;
import ua.lviv.iot.model.HealthInfo;

@Service
public class HealthInfoServiceImpl implements HealthInfoDao {

    private HealthInfoDaoImpl dao;
    
    @Autowired
    public HealthInfoServiceImpl(HealthInfoDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<HealthInfo> findAll() {
        return dao.findAll();
    }

    public Optional<HealthInfo> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public int save(HealthInfo entity) {
        return dao.save(entity);
    }

    @Override
    public int update(HealthInfo entity, Long id) {
        return dao.update(entity, id);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

}
