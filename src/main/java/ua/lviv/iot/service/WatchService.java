package ua.lviv.iot.service;

import java.util.List;

import ua.lviv.iot.model.Owner;
import ua.lviv.iot.model.Watch;

public interface WatchService extends GeneralService<Watch, String>{

    List<Owner>findAllWatchOwnersBySerialNumber(String serialNumber);
}
