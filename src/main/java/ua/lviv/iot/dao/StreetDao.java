package ua.lviv.iot.dao;

import java.util.Optional;

import ua.lviv.iot.model.Street;

public interface StreetDao extends GeneralDao<Street, String>{

    Optional<Street>findStreetByName(String name);
}
