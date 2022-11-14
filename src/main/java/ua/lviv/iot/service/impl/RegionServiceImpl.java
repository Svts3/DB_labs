package ua.lviv.iot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.exception.RegionNotFoundException;
import ua.lviv.iot.model.City;
import ua.lviv.iot.model.Region;
import ua.lviv.iot.repository.RegionRepository;
import ua.lviv.iot.service.RegionService;

@Service
public class RegionServiceimpl implements RegionService {

    private static final String REGION_NOT_FOUND_EXCEPTION_MESSAGE = "Region was not found!";

    private RegionRepository repository;

    @Autowired
    public RegionServiceimpl(RegionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Region> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Region save(Region entity) {
        return repository.save(entity);
    }

    @Override
    public Region findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException(REGION_NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @Override
    public Region update(Region entity, String id) {
        Region region = findById(id);
        repository.deleteById(id);
        region.setName(id);
        region.setCities(entity.getCities());
        region.setCountry(entity.getCountry());
        return repository.save(region);
    }

    @Transactional
    @Override
    public Region deleteById(String id) {
        Region region = findById(id);
        repository.deleteById(id);
        return region;
    }

    @Override
    public List<City> findAllCitiesByRegionName(String regionName) {
        Region region = findById(regionName);
        return region.getCities();
    }

}
