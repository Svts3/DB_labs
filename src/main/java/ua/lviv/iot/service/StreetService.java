package ua.lviv.iot.service;

import java.util.Optional;

import ua.lviv.iot.model.Street;

public interface StreetService extends GeneralService<Street, String>{

    Optional<Street>findStreetByName(String name);
}
