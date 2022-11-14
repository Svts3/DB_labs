package ua.lviv.iot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.model.Watch;

@Repository
public interface WatchRepository extends JpaRepository<Watch, String>{
    
    Optional<Watch>findByStreetName(String streetName);
}
