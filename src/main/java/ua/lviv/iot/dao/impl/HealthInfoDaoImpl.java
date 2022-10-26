package ua.lviv.iot.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.HealthInfoDao;
import ua.lviv.iot.model.HealthInfo;

@Service
public class HealthInfoDaoImpl implements HealthInfoDao {

    private final String FIND_ALL = "SELECT * FROM health_info";

    private final String FIND_BY_ID = "SELECT * FROM health_info where id=?";

    private final String CREATE = "INSERT INTO health_info(heartbeat_rate, watch_serial_number) VALUES(?,?)";

    private final String UPDATE = "UPDATE health_info SET heartbeat_rate=?, watch_serial_number=? WHERE id=?";
    private final String DELETE = "DELETE FROM health_info WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public HealthInfoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<HealthInfo> findAll() {
        // TODO Auto-generated method stub
        return jdbcTemplate.query(FIND_ALL,
                new BeanPropertyRowMapper().newInstance(HealthInfo.class));
    }

    public Optional<HealthInfo> findById(Long id) {
        return jdbcTemplate
                .query(FIND_BY_ID, new BeanPropertyRowMapper().newInstance(HealthInfo.class), id)
                .stream().findAny();
    }

    @Override
    public int save(HealthInfo entity) {
        return jdbcTemplate.update(CREATE, entity.getHeartbeatRate(),
                entity.getWatchSerialNumber());
    }

    @Override
    public int update(HealthInfo entity, Long id) {
        return jdbcTemplate.update(UPDATE, entity.getHeartbeatRate(), entity.getWatchSerialNumber(),
                id);
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(DELETE, id);
    }

}
