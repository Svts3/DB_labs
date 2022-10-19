package ua.lviv.iot.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.EmergencyPhoneNumberDao;
import ua.lviv.iot.model.EmergencyPhoneNumber;

@Service
public class EmergencyPhoneNumberDaoImpl implements EmergencyPhoneNumberDao {

    private final String FIND_ALL = "SELECT * FROM emergency_phone_number";

    private final String FIND_BY_ID = "SELECT * FROM emergency_phone_number where id=?";

    private final String CREATE = "INSERT INTO emergency_phone_number(phone_number,"
            + " watch_serial_number) VALUES(?,?)";

    private final String UPDATE = "UPDATE emergency_phone_number SET phone_number=?, watch_serial_number=?"
            + " WHERE id=?";
    private final String DELETE = "DELETE FROM emergency_phone_number WHERE id=?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmergencyPhoneNumberDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EmergencyPhoneNumber> findAll() {
        return jdbcTemplate.query(FIND_ALL,
                new BeanPropertyRowMapper().newInstance(EmergencyPhoneNumber.class));
    }

    public Optional<EmergencyPhoneNumber> findById(Long id) {
        return jdbcTemplate
                .query(FIND_BY_ID,
                        new BeanPropertyRowMapper().newInstance(EmergencyPhoneNumber.class), id)
                .stream().findAny();
    }

    @Override
    public int save(EmergencyPhoneNumber entity) {
        return jdbcTemplate.update(CREATE, entity.getPhoneNumber(), entity.getWatchSerialNumber());
    }

    @Override
    public int update(EmergencyPhoneNumber entity, Long id) {
        return jdbcTemplate.update(CREATE, entity.getPhoneNumber(), entity.getWatchSerialNumber(), id);
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(DELETE, id);
    }

}
