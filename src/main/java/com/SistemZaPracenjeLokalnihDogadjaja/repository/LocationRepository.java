package com.SistemZaPracenjeLokalnihDogadjaja.repository;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    Optional<Location> findByLocationName(String locationName);
}
