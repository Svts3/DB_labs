package ua.lviv.iot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Street;
@Service
public interface CityService extends GeneralService<City, String>{

    List<Street>findAllStreetsByCityName(String cityName);
}
