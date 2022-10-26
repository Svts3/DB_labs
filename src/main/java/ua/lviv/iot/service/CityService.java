package ua.lviv.iot.service;

import java.util.Optional;

import ua.lviv.iot.model.City;

public interface CityService extends GeneralService<City, String>{

    Optional<City>findCityByName(String name);
}
