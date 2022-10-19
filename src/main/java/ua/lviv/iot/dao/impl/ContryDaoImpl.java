package ua.lviv.iot.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.CountryDao;
import ua.lviv.iot.model.Country;

@Service
public class ContryDaoImpl implements CountryDao {

    private final String FIND_ALL = "SELECT * FROM country";

    private final String FIND_BY_ID = "SELECT * FROM country where id=?";

    private final String FIND_BY_NAME = "SELECT * FROM country WHERE name=?";

    private final String CREATE = "INSERT INTO country(name) VALUES(?)";

    private final String UPDATE = "UPDATE country SET name=? WHERE name=?";
    private final String DELETE = "DELETE FROM country WHERE name=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ContryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Country> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper().newInstance(Country.class));
    }


    @Override
    public int save(Country entity) {
        return jdbcTemplate.update(CREATE, entity.getName());
    }

    @Override
    public int update(Country entity, String id) {
        return jdbcTemplate.update(UPDATE, entity.getName(), id);
    }

    @Override
    public int deleteById(String id) {
        // TODO Auto-generated method stub
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Country> findCountryByName(String name) {
        return jdbcTemplate
                .query(FIND_BY_NAME, new BeanPropertyRowMapper().newInstance(Country.class), name)
                .stream().findAny();
    }

}
