package ua.lviv.iot.controller;

import java.util.Optional;

import ua.lviv.iot.model.Country;

public interface CountryController extends GeneralController<Country, String>{

    Optional<Country>findCountryByName(String name);
}
