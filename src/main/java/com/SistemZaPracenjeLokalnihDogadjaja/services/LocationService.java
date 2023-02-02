package com.SistemZaPracenjeLokalnihDogadjaja.services;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Location;
import com.SistemZaPracenjeLokalnihDogadjaja.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    public List<Location> findAllLocation() {
        return locationRepository.findAll();
    }

    public Location findById(int id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.orElseThrow(() -> new NoSuchElementException("There is no Location with id: " + id));
    }

    public Location saveLocation(Location location) {

        return locationRepository.save(location);
    }


}
