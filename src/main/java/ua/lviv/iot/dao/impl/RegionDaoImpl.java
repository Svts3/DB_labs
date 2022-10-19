package ua.lviv.iot.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.RegionDao;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.model.Region;

@Service
public class RegionDaoImpl implements RegionDao {

    private final String FIND_ALL = "SELECT * FROM region";

    private final String FIND_BY_ID = "SELECT * FROM region where id=?";

    private final String FIND_BY_NAME = "SELECT * FROM region WHERE name=?";

    private final String CREATE = "INSERT INTO region(name, country_name) VALUES(?, ?)";

    private final String UPDATE = "UPDATE region SET name=?, region_name=? WHERE id=?";
    private final String DELETE = "DELETE FROM region WHERE name=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RegionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Region> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper().newInstance(Region.class));
    }

    @Override
    public int save(Region entity) {
        // TODO Auto-generated method stub
        return jdbcTemplate.update(CREATE, entity.getName(), entity.getCountryName());
    }

    @Override
    public int update(Region entity, String id) {
        return jdbcTemplate.update(UPDATE, entity.getName(), entity.getCountryName(), id);
    }

    @Override
    public int deleteById(String id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Region> findRegionByName(String name) {
        return jdbcTemplate
                .query(FIND_BY_NAME, new BeanPropertyRowMapper().newInstance(Region.class), name)
                .stream().findAny();
    }

}
