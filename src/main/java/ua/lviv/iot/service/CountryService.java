package ua.lviv.iot.service;

import java.util.Optional;

import ua.lviv.iot.model.Country;

public interface CountryService extends GeneralService<Country, String>{

    Optional<Country>findCountryByName(String name);
}
