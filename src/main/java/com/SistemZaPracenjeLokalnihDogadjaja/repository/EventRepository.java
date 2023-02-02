package com.SistemZaPracenjeLokalnihDogadjaja.repository;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Events, Integer> {
    @Query(value = "select e from Events e where " + "lower(e.category.title) like lower(concat('%',:keyword,'%'))"
           + "or lower(e.location.locationName) like lower(concat('%',:keyword,'%'))")
    public List<Events> searchEvents(@Param("keyword") String keyword);
}
