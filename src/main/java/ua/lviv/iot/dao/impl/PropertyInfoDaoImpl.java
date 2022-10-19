package ua.lviv.iot.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.PropertyInfoDao;
import ua.lviv.iot.model.PropertyInfo;

@Service
public class PropertyInfoDaoImpl implements PropertyInfoDao {

    private final String FIND_ALL = "SELECT * FROM property_info";

    private final String FIND_BY_ID = "SELECT * FROM property_info where id=?";

    private final String CREATE = "INSERT INTO property_info(owner_id,"
            + " watch_serial_number) VALUES(?,?)";

    private final String UPDATE = "UPDATE property_info SET owner_id=?,"
            + " watch_serial_number=? WHERE id=?";
    private final String DELETE = "DELETE FROM property_info WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PropertyInfoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PropertyInfo> findAll() {
        return jdbcTemplate.query(FIND_ALL,
                new BeanPropertyRowMapper().newInstance(PropertyInfo.class));
    }

    public Optional<PropertyInfo> findById(Long id) {
        return jdbcTemplate
                .query(FIND_BY_ID, new BeanPropertyRowMapper().newInstance(PropertyInfo.class), id)
                .stream().findAny();
    }

    @Override
    public int save(PropertyInfo entity) {
        return jdbcTemplate.update(CREATE, entity.getOwnerId(), entity.getWatchSerialNumber());
    }

    @Override
    public int update(PropertyInfo entity, Long id) {
        return jdbcTemplate.update(UPDATE, entity.getOwnerId(), entity.getWatchSerialNumber(), id);
    }

    @Override
    public int deleteById(Long id) {
        return this.jdbcTemplate.update(DELETE, id);
    }

}
