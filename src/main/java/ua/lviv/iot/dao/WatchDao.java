package ua.lviv.iot.dao;

import java.util.Optional;

import ua.lviv.iot.model.Watch;

public interface WatchDao extends GeneralDao<Watch, String>{

    Optional<Watch> findWatchBySerialNumber(String serialNumber);
    
}
