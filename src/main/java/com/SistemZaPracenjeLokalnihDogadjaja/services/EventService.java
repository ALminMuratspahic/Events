package com.SistemZaPracenjeLokalnihDogadjaja.services;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Events;
import com.SistemZaPracenjeLokalnihDogadjaja.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Events> findAllEvents() {
        return eventRepository.findAll();
    }

    public Events findById(int id) {
        Optional<Events> events = eventRepository.findById(id);
        return events.orElseThrow(() -> new NoSuchElementException("No Events with id: " + id));
    }

    public Events saveEvents(Events events) {
        return eventRepository.save(events);
    }

    public List<Events> searchEvents(String categoryTitle) {
        if (categoryTitle == null || categoryTitle.isEmpty()) {
            return eventRepository.findAll();
        } else {
            return eventRepository.searchEvents(categoryTitle);
        }
    }
}
