package com.SistemZaPracenjeLokalnihDogadjaja.contorller;

import com.SistemZaPracenjeLokalnihDogadjaja.model.*;
import com.SistemZaPracenjeLokalnihDogadjaja.myutils.ImageUtil;
import com.SistemZaPracenjeLokalnihDogadjaja.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller()
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    private final LocationService locationService;

    private final CategoryService categoryService;

    @GetMapping
    public String eventsHome(Model model) {
        List<Events> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        model.addAttribute("imgUtil", new ImageUtil());
        return "event_main";
    }

    @GetMapping("/create")
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
        events.setComments(new ArrayList<>());
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
        return "event_main";
    }

    @GetMapping("/{id}")
    public ModelAndView editEvents(@PathVariable(name = "id") int id, Model model) {
        ModelAndView modelAndView = new ModelAndView("edit_event");
        Events event = eventService.findById(id);
        Location location = event.getLocation();
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("event", event);
        model.addAttribute("locations", locationService.findAllLocation());
        model.addAttribute("categories", categories);
        return modelAndView;
    }


}
