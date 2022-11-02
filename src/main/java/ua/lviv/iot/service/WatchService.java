package ua.lviv.iot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.lviv.iot.model.Owner;
import ua.lviv.iot.model.Watch;
@Service
public interface WatchService extends GeneralService<Watch, String>{

    List<Owner>findAllWatchOwnersBySerialNumber(String serialNumber);
}
