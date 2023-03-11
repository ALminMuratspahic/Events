package com.SistemZaPracenjeLokalnihDogadjaja.contorller;

import com.SistemZaPracenjeLokalnihDogadjaja.myutils.ImageUtil;
import com.SistemZaPracenjeLokalnihDogadjaja.model.Location;
import com.SistemZaPracenjeLokalnihDogadjaja.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public String getAllLocations(Model model) {
        List<Location> locations = locationService.findAllLocation();
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("locations", locations);
        return "locations";
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public String saveLocation(@ModelAttribute Location location, @RequestParam("image") MultipartFile multipartFile)
            throws IOException {
        location.setImageData(multipartFile.getBytes());
        locationService.saveLocation(location);
        return "redirect:/events";
    }

    @GetMapping("/create-location")
    public String createLocation(Model model) {
        Location location = new Location();
        model.addAttribute("location", location);
        return "create_location";
    }

}
