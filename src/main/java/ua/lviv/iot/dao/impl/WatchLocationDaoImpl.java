package ua.lviv.iot.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.WatchLocationDao;
import ua.lviv.iot.model.WatchLocation;
@Service
public class WatchLocationDaoImpl implements WatchLocationDao {

    private final String FIND_ALL = "SELECT * FROM watch_location";

    private final String FIND_BY_ID = "SELECT * FROM watch_location where id=?";

    private final String CREATE = "INSERT INTO watch_location(latitude, longitude, watch_serial_number) VALUES(?,?,?)";

    private final String UPDATE = "UPDATE watch_location SET latitude=?, longitude=?,"
            + " watch_serial_number=? WHERE id=?";
    private final String DELETE = "DELETE FROM watch_location WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WatchLocationDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WatchLocation> findAll() {
        return jdbcTemplate.query(FIND_ALL,
                new BeanPropertyRowMapper().newInstance(WatchLocation.class));
    }

    public Optional<WatchLocation> findById(Long id) {
        return jdbcTemplate
                .query(FIND_BY_ID, new BeanPropertyRowMapper().newInstance(WatchLocation.class),id)
                .stream().findAny();
    }

    @Override
    public int save(WatchLocation entity) {
        return jdbcTemplate.update(CREATE, entity.getLatitude(), entity.getLongitude(),
                entity.getWatchSerialNumber());
    }

    @Override
    public int update(WatchLocation entity, Long id) {
        return jdbcTemplate.update(UPDATE, entity.getLatitude(), entity.getLongitude(),
                entity.getWatchSerialNumber(), id);
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(DELETE, id);
    }

}
