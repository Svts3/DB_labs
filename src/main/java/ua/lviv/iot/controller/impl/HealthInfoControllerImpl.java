package ua.lviv.iot.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.HealthInfoDao;
import ua.lviv.iot.dao.impl.HealthInfoDaoImpl;
import ua.lviv.iot.model.HealthInfo;
import ua.lviv.iot.service.impl.HealthInfoServiceImpl;

@Controller
public class HealthInfoControllerImpl implements HealthInfoDao {

    private HealthInfoServiceImpl service;
    
    @Autowired
    public HealthInfoControllerImpl(HealthInfoServiceImpl service) {
        this.service = service;
    }

    @Override
    public List<HealthInfo> findAll() {
        return service.findAll();
    }

    public Optional<HealthInfo> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public int save(HealthInfo entity) {
        return service.save(entity);
    }

    @Override
    public int update(HealthInfo entity, Long id) {
        return service.update(entity, id);
    }

    @Override
    public int deleteById(Long id) {
        return service.deleteById(id);
    }

}
