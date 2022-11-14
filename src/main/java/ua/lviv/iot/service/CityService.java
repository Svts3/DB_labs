package ua.lviv.iot.service;

import java.util.List;

import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Street;

public interface CityService extends GeneralService<City, String>{

    List<Street>findAllStreetsByCityName(String cityName);
}
