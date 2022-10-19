package ua.lviv.iot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dao.UserDao;
import ua.lviv.iot.dao.impl.UserDaoImpl;
import ua.lviv.iot.model.User;

@Service
public class UserServiceImpl implements UserDao {

    private UserDaoImpl dao;

    @Autowired
    public UserServiceImpl(UserDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return dao.findAll();
    }

    public Optional<User> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public int save(User entity) {
        return dao.save(entity);
    }

    @Override
    public int update(User entity, Long id) {
        return dao.update(entity, id);

    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public List<User> findUsersByFirstName(String firstName) {
        return dao.findUsersByFirstName(firstName);
    }

    @Override
    public List<User> findUsersByLastName(String lastName) {
        return dao.findUsersByLastName(lastName);
    }

}
