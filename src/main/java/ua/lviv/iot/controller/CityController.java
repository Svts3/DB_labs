package ua.lviv.iot.controller;

import java.util.Optional;

import ua.lviv.iot.model.City;

public interface CityController extends GeneralController<City, String>{

    Optional<City>findCityByName(String name);
}
