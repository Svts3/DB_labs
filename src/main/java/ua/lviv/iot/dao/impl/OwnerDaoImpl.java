package ua.lviv.iot.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.OwnerDao;
import ua.lviv.iot.model.Owner;

@Service
public class OwnerDaoImpl implements OwnerDao {

    private final String FIND_ALL = "SELECT * FROM owner";

    private final String FIND_BY_ID = "SELECT * FROM owner where id=?";
    private final String FIND_BY_FIRST_NAME = "SELECT * FROM owner where first_name=?";
    private final String FIND_BY_LAST_NAME = "SELECT * FROM owner where last_name=?";

    private final String CREATE = "INSERT INTO owner(first_name, last_name, date_of_birth,"
            + " gender) VALUES(?,?,?,?)";

    private final String UPDATE = "UPDATE owner SET first_name=?, last_name=?,"
            + " date_of_birth=?, gender=? WHERE id=?";
    private final String DELETE = "DELETE FROM owner WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OwnerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Owner> findAll() {

        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper().newInstance(Owner.class));
    }

    public Optional<Owner> findById(Long id) {

        Optional<Owner> owner = Optional.of(jdbcTemplate.queryForObject(FIND_BY_ID,
                new BeanPropertyRowMapper<>().newInstance(Owner.class), id));

        return owner;

    }

    @Override
    public int save(Owner entity) {

        return jdbcTemplate.update(CREATE, entity.getFirstName(), entity.getLastName(),
                entity.getDateOfBirth().toString(), entity.getGender());

    }

    @Override
    public int update(Owner entity, Long id) {
        return jdbcTemplate.update(UPDATE, entity.getFirstName(), entity.getLastName(),
                entity.getDateOfBirth().toString(), entity.getGender(), id);
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<Owner> findOwnersByFirstName(String firstName) {
        return jdbcTemplate.query(FIND_BY_FIRST_NAME,
                new BeanPropertyRowMapper().newInstance(Owner.class), firstName);
    }

    @Override
    public List<Owner> findOwnersByLastName(String lastName) {
        return jdbcTemplate.query(FIND_BY_LAST_NAME,
                new BeanPropertyRowMapper().newInstance(Owner.class), lastName);
    }

}
