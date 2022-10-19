package ua.lviv.iot.dao;

import java.util.Optional;

import ua.lviv.iot.model.Country;

public interface CountryDao extends GeneralDao<Country, String>{

    Optional<Country>findCountryByName(String name);
}
