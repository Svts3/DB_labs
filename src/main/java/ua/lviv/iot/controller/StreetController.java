package ua.lviv.iot.controller;

import java.util.Optional;

import ua.lviv.iot.model.Street;

public interface StreetController extends GeneralController<Street, String>{

    Optional<Street>findStreetByName(String name);
}
