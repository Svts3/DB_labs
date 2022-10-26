package ua.lviv.iot.dao;

import java.util.Optional;

import ua.lviv.iot.model.City;

public interface CityDao extends GeneralDao<City, String>{

    Optional<City>findCityByName(String name);
}
