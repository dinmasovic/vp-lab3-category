package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.service.CategoryService;
import mk.finki.ukim.mk.lab.service.impl.CategoryServiceImpl;
import mk.finki.ukim.mk.lab.service.impl.EventServiceImpl;
import mk.finki.ukim.mk.lab.service.impl.LocationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/events/edit/{eventId}")
public class EventEditController {
    private LocationServiceImpl locations;
    private CategoryServiceImpl categories;
    private EventServiceImpl obj;

    public EventEditController(LocationServiceImpl locations, EventServiceImpl obj,CategoryServiceImpl categories) {
        this.locations = locations;
        this.obj = obj;
        this.categories=categories;
    }

    @PostMapping
    public String getEventsPage(@PathVariable Long eventId, @RequestParam String editName,
                                @RequestParam String editRate, @RequestParam String editDes,
                                @RequestParam(required = false,defaultValue = "7") String editLocation,@RequestParam(required = false,defaultValue = "1") String editCategory ,Model model) {
        Event event = obj.findById(eventId);
        if(editName !=null)
            event.setName(editName);
        if(editRate!=null)
            event.setPopularityScore(Double.parseDouble(editRate));
        if(editDes!=null)
            event.setDescription(editDes);
        if(editLocation !=null)
            event.setLocation(locations.findByID(Long.parseLong(editLocation)));
        else {
            Location defaultLocation = locations.findByID(Long.parseLong("7"));
            locations.save(defaultLocation);
            event.setLocation(defaultLocation);
        }
        if(editCategory !=null)
            event.setCategory(categories.findByID(Long.parseLong(editCategory)));
        else {
            Category defaultCategory = categories.findByID(Long.parseLong("1"));
            categories.save(defaultCategory);
            event.setCategory(defaultCategory);
        }
        obj.save(event);
        return "redirect:/events";
    }
    @GetMapping
    public String editEvent(@PathVariable Long eventId,Model model){
        model.addAttribute("locations",locations.findAll());
        model.addAttribute("rate",obj.findById(eventId).popularityScore);
        model.addAttribute("des",obj.findById(eventId).description);
        model.addAttribute("name",obj.findById(eventId).name);
        model.addAttribute("categories",categories.findAll());
        //obj.findById(eventId).name="da";
        return "add-event";
    }
}
