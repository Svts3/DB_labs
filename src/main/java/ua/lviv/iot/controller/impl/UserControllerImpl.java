package ua.lviv.iot.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.UserDao;
import ua.lviv.iot.dao.impl.UserDaoImpl;
import ua.lviv.iot.model.Owner;
import ua.lviv.iot.model.User;

@Controller
public class UserControllerImpl implements UserDao {

    private UserDaoImpl service;

    @Autowired
    public UserControllerImpl(UserDaoImpl service) {
        this.service = service;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return service.findAll();
    }

    public Optional<User> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public int save(User entity) {
        return service.save(entity);
    }

    @Override
    public int update(User entity, Long id) {
        return service.update(entity, id);

    }

    @Override
    public int deleteById(Long id) {
        return service.deleteById(id);
    }

    @Override
    public List<User> findUsersByFirstName(String firstName) {
        return service.findUsersByFirstName(firstName);
    }

    @Override
    public List<User> findUsersByLastName(String lastName) {
        return service.findUsersByLastName(lastName);
    }

}
