package ua.lviv.iot.controller;

import java.util.Optional;

import ua.lviv.iot.model.Region;

public interface RegionController extends GeneralController<Region, String>{

    Optional<Region>findRegionByName(String name);
}
