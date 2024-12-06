package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.LocationRepository;
import mk.finki.ukim.mk.lab.service.CategoryService;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import mk.finki.ukim.mk.lab.service.impl.EventServiceImpl;
import mk.finki.ukim.mk.lab.service.impl.LocationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/events/add")
public class EventSavedController {
    private EventService obj;
    private LocationService locations;
    private CategoryService categories;

    public EventSavedController(EventService obj, LocationService locations,CategoryService categories) {
        this.obj = obj;
        this.locations = locations;
        this.categories=categories;
    }

    @PostMapping
    public String saveEvent(@RequestParam String editName,@RequestParam String editDes,@RequestParam String editRate,@RequestParam String editLocation,@RequestParam String editCategory){
        Event newEvent=new Event(editName,editDes,Double.parseDouble(editRate));
        newEvent.setLocation(locations.findByID(Long.parseLong(editLocation)));
        newEvent.setCategory(categories.findByID(Long.parseLong(editCategory)));
        obj.addEvent(newEvent);
        return "redirect:/events";
    }
    @GetMapping
    public String getHtml(Model model){
        model.addAttribute("locations",locations.findAll());
        model.addAttribute("categories",categories.findAll());
        return "add-event";
    }


}
