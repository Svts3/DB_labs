package ua.lviv.iot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.lviv.iot.model.Country;
import ua.lviv.iot.model.Region;
@Service
public interface CountryService extends GeneralService<Country, String>{

    List<Region> findAllRegionsByCountryName(String countryName);
}
