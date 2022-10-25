package ua.lviv.iot.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.WatchBatteryDao;
import ua.lviv.iot.model.WatchBattery;

@Service
public class WatchBatteryDaoImpl implements WatchBatteryDao {

    private final String FIND_ALL = "SELECT * FROM watch_battery";

    private final String FIND_BY_ID = "SELECT * FROM watch_battery where id=?";

    private final String CREATE = "INSERT INTO watch_battery(charge_level, watch_serial_number)"
            + " VALUES(?,?)";

    private final String UPDATE = "UPDATE watch_battery SET charge_level=?, watch_serial_number=? "
            + "WHERE id=?";
    private final String DELETE = "DELETE FROM watch_battery WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WatchBatteryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WatchBattery> findAll() {
        return jdbcTemplate.query(FIND_ALL,
                new BeanPropertyRowMapper().newInstance(WatchBattery.class));
    }

    public Optional<WatchBattery> findById(Long id) {
        return jdbcTemplate
                .query(FIND_BY_ID, new BeanPropertyRowMapper().newInstance(WatchBattery.class), id)
                .stream().findAny();
    }

    @Override
    public int save(WatchBattery entity) {
        return jdbcTemplate.update(CREATE, entity.getChargeLevel(), entity.getWatchSerialNumber());
    }

    @Override
    public int update(WatchBattery entity, Long id) {
        return jdbcTemplate.update(UPDATE, entity.getChargeLevel(), entity.getWatchSerialNumber(), id);
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(DELETE, id);
    }

}
