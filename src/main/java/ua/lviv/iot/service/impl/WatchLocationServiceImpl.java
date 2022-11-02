package ua.lviv.iot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.lviv.iot.exception.WatchLocationNotFoundException;
import ua.lviv.iot.model.WatchLocation;
import ua.lviv.iot.repository.WatchLocationRepository;
import ua.lviv.iot.service.WatchLocationService;
@Service
public class WatchLocationServiceImpl implements WatchLocationService {

    private static final String WATCH_LOCATION_NOT_FOUND_EXCEPTION_MESSAGE = "Health info was not found!";

    private WatchLocationRepository repository;

    @Override
    public List<WatchLocation> findAll() {
        return repository.findAll();
    }

    @Override
    public WatchLocation save(WatchLocation entity) {
        return repository.save(entity);
    }

    @Override
    public WatchLocation findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new WatchLocationNotFoundException(
                WATCH_LOCATION_NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @Override
    public WatchLocation update(WatchLocation entity, Long id) {
        WatchLocation watchLocation = findById(id);
        watchLocation.setId(id);
        watchLocation.setLatitude(entity.getLatitude());
        watchLocation.setLongitude(entity.getLongitude());
        watchLocation.setWatch(entity.getWatch());
        return repository.save(watchLocation);
    }

    @Override
    public WatchLocation deleteById(Long id) {
        WatchLocation watchLocation = findById(id);
        repository.deleteById(id);
        return watchLocation;
    }

}
