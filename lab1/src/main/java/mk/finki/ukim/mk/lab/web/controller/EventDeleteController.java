package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.impl.EventServiceImpl;
import mk.finki.ukim.mk.lab.service.impl.LocationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/events/delete/{eventId}")
public class EventDeleteController {
    private EventService obj;
    public EventDeleteController(EventService obj){
        this.obj=obj;
    }
    @PostMapping
    public String eventDeleted(@PathVariable Long eventId, Model model, HttpServletRequest req){
        obj.removeEvent(eventId);
        return "redirect:/events";
    }
}
