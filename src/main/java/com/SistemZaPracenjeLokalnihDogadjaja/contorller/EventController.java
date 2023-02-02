package com.SistemZaPracenjeLokalnihDogadjaja.contorller;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Category;
import com.SistemZaPracenjeLokalnihDogadjaja.model.Events;
import com.SistemZaPracenjeLokalnihDogadjaja.model.Location;
import com.SistemZaPracenjeLokalnihDogadjaja.myutils.ImageUtil;

import com.SistemZaPracenjeLokalnihDogadjaja.services.CategoryService;
import com.SistemZaPracenjeLokalnihDogadjaja.services.EventService;
import com.SistemZaPracenjeLokalnihDogadjaja.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String eventsHome(Model model) {
        List<Events> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        model.addAttribute("imgUtil", new ImageUtil());
        return "event_main";
    }

    @GetMapping("/create-event")
    public String createEvents(Model model) {
        Events events = new Events();
        List<Location> locations = locationService.findAllLocation();
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("event", events);
        model.addAttribute("locations", locations);
        model.addAttribute("categories", categories);
        return "create_event";
    }

    @PostMapping
    public String saveEvent(Events events) {
        eventService.saveEvents(events);
        return "redirect:/events";
    }

    @GetMapping("/search")
    public String searchEvents(Model model, String categoryTitle) {
        List<Events> events;
        if (categoryTitle != null) {
            events = eventService.searchEvents(categoryTitle);
        } else {
            events = eventService.findAllEvents();
        }
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("events", events);
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("categories", categories);
        System.out.println(events);
        return "event_main";
    }

}
