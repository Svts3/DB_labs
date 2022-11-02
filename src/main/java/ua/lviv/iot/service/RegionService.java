package ua.lviv.iot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Region;
@Service
public interface RegionService extends GeneralService<Region, String>{

    List<City> findAllCitiesByRegionName(String regionName);
}
