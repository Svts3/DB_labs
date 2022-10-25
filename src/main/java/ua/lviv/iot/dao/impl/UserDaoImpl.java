package ua.lviv.iot.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.UserDao;
import ua.lviv.iot.model.Owner;
import ua.lviv.iot.model.User;

@Service
public class UserDaoImpl implements UserDao {

    private final String FIND_ALL = "SELECT * FROM user";

    private final String FIND_BY_ID = "SELECT * FROM user where id=?";
    private final String FIND_BY_FIRST_NAME = "SELECT * FROM user where first_name=?";
    private final String FIND_BY_LAST_NAME = "SELECT * FROM user where last_name=?";

    private final String CREATE = "INSERT INTO user(first_name, last_name, date_of_birth,"
            + " gender, property_info_id) VALUES(?,?,?,?,?)";

    private final String UPDATE = "UPDATE user SET first_name=?, last_name=?,"
            + " date_of_birth=?, gender=?, property_info_id=? WHERE id=?";
    private final String DELETE = "DELETE FROM user WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper().newInstance(User.class));
    }

    public Optional<User> findById(Long id) {
        return jdbcTemplate
                .query(FIND_BY_ID, new BeanPropertyRowMapper().newInstance(User.class), id).stream()
                .findAny();
    }

    @Override
    public int save(User entity) {
        return jdbcTemplate.update(CREATE, entity.getFirstName(), entity.getLastName(),
                entity.getDateOfBirth().toString(), entity.getGender(), entity.getPropertyInfoId());
    }

    @Override
    public int update(User entity, Long id) {
        return jdbcTemplate.update(UPDATE, entity.getFirstName(), entity.getLastName(),
                entity.getDateOfBirth().toString(), entity.getGender(), entity.getPropertyInfoId(),
                id);

    }

    @Override
    public int deleteById(Long id) {
        // TODO Auto-generated method stub
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<User> findUsersByFirstName(String firstName) {
        return jdbcTemplate.query(FIND_BY_FIRST_NAME,
                new BeanPropertyRowMapper().newInstance(User.class), firstName);
    }

    @Override
    public List<User> findUsersByLastName(String lastName) {
        // TODO Auto-generated method stub
        return jdbcTemplate.query(FIND_BY_LAST_NAME,
                new BeanPropertyRowMapper().newInstance(User.class), lastName);
    }

}
