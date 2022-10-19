package ua.lviv.iot.dao;

import java.util.Optional;

import ua.lviv.iot.model.Region;

public interface RegionDao extends GeneralDao<Region, String>{

    Optional<Region>findRegionByName(String name);
}
