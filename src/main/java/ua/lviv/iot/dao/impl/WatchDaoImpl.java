package ua.lviv.iot.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.WatchDao;
import ua.lviv.iot.model.Watch;
@Service
public class WatchDaoImpl implements WatchDao {

    private final String FIND_ALL = "SELECT * FROM watch";

    private final String FIND_BY_SERIAL_NUMBER = "SELECT * FROM watch where serial_number=?";

    private final String CREATE = "INSERT INTO watch(serial_number, street_name)" + " VALUES(?,?)";

    private final String UPDATE = "UPDATE watch SET serial_number=?, street_name=?" + "WHERE serial_number=?";
    private final String DELETE = "DELETE FROM watch WHERE serial_number=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WatchDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Watch> findAll() {

        return this.jdbcTemplate.query(FIND_ALL,
                new BeanPropertyRowMapper().newInstance(Watch.class));
    }

    public Optional<Watch> findById(Long id) {
        return Optional.of(this.jdbcTemplate.queryForObject(UPDATE,
                new BeanPropertyRowMapper().newInstance(Watch.class), id));
    }

    @Override
    public int save(Watch entity) {
        return jdbcTemplate.update(CREATE, entity.getSerialNumber(), entity.getStreetName());
    }
    @Override
    public int update(Watch entity, String serialNumber) {
        return jdbcTemplate.update(UPDATE, entity.getSerialNumber(), entity.getStreetName(), serialNumber);
    }

    @Override
    public int deleteById(String id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Watch> findWatchBySerialNumber(String serialNumber) {
        return jdbcTemplate
                .query(FIND_BY_SERIAL_NUMBER,
                        new BeanPropertyRowMapper<>().newInstance(Watch.class), serialNumber)
                .stream().findFirst();
    }


}
