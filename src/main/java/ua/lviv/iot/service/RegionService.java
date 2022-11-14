package ua.lviv.iot.service;

import java.util.List;

import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Region;

public interface RegionService extends GeneralService<Region, String>{

    List<City> findAllCitiesByRegionName(String regionName);
}
