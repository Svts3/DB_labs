package ua.lviv.iot.controller;

import java.util.Optional;

import ua.lviv.iot.model.Watch;

public interface WatchController extends GeneralController<Watch, Long>{

    Optional<Watch> findWatchBySerialNumber(String serialNumber);
    
}
