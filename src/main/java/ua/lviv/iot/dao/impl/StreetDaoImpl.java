package ua.lviv.iot.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.StreetDao;
import ua.lviv.iot.model.Street;
@Service
public class StreetDaoImpl implements StreetDao {

    private final String FIND_ALL = "SELECT * FROM street";

    private final String FIND_BY_NAME = "SELECT * FROM street WHERE name=?";

    private final String CREATE = "INSERT INTO street(name, city_name) VALUES(?,?)";

    private final String UPDATE = "UPDATE street SET name=?, city_name=? WHERE name=?";
    private final String DELETE = "DELETE FROM street WHERE name=?";

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public StreetDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Street> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper().newInstance(Street.class));
    }


    @Override
    public int save(Street entity) {
        return jdbcTemplate.update(CREATE, entity.getName(), entity.getCityName());
    }

    @Override
    public int update(Street entity, String id) {
        return jdbcTemplate.update(UPDATE, entity.getName(), entity.getCityName(), id);
    }

    @Override
    public int deleteById(String id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Street> findStreetByName(String name) {

        return jdbcTemplate
                .query(FIND_BY_NAME, new BeanPropertyRowMapper().newInstance(Street.class), name).stream()
                .findAny();
    }

}
