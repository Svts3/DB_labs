package ua.lviv.iot.service;

import java.util.Optional;

import ua.lviv.iot.model.Watch;

public interface WatchService extends GeneralService<Watch, Long>{

    Optional<Watch> findWatchBySerialNumber(String serialNumber);
    
}
