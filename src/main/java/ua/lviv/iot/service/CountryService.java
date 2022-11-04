package ua.lviv.iot.service;

import java.util.List;

import ua.lviv.iot.model.Country;
import ua.lviv.iot.model.Region;

public interface CountryService extends GeneralService<Country, String>{

    List<Region> findAllRegionsByCountryName(String countryName);
}
