package ua.lviv.iot.service;

import java.util.Optional;

import ua.lviv.iot.model.Region;

public interface RegionService extends GeneralService<Region, String>{

    Optional<Region>findRegionByName(String name);
}
