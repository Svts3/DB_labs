package ua.lviv.iot.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.CityDao;
import ua.lviv.iot.model.City;
@Service
public class CityDaoImpl implements CityDao {

    private final String FIND_ALL = "SELECT * FROM city";

    private final String FIND_BY_ID = "SELECT * FROM city where id=?";

    private final String FIND_BY_NAME = "SELECT * FROM city WHERE name=?";

    private final String CREATE = "INSERT INTO city(name, region_name) VALUES(?, ?)";

    private final String UPDATE = "UPDATE city SET name=?, region_name=? WHERE name=?";
    private final String DELETE = "DELETE FROM city WHERE name=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CityDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<City> findAll() {
        // TODO Auto-generated method stub
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper().newInstance(City.class));
    }


    @Override
    public int save(City entity) {
        // TODO Auto-generated method stub
        return jdbcTemplate.update(CREATE, entity.getName(), entity.getRegionName());
    }

    @Override
    public int update(City entity, String id) {
        return jdbcTemplate.update(UPDATE, entity.getName(), entity.getRegionName(), id);
    }

    @Override
    public int deleteById(String id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<City> findCityByName(String name) {
        return jdbcTemplate
                .query(FIND_BY_NAME, new BeanPropertyRowMapper().newInstance(City.class), name)
                .stream().findAny();
    }

}
