package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/eventsByCategory")
public class EventsByCategoryController {
    private EventService eventService;

    public EventsByCategoryController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping
    public String getHTML(@RequestParam String categoryId, Model model){
        List<Event> lista=eventService.listAll();
        lista=lista.stream().filter(s->s.getCategory().getId().equals(Long.parseLong(categoryId))).toList();
        model.addAttribute("lista",lista);
        return "listEventsByCategory";
    }
    @PostMapping
    public String post(@RequestParam String categoryId, Model model){
        List<Event> lista=eventService.listAll();
        lista=lista.stream().filter(s->s.getCategory().getId().equals(Long.parseLong(categoryId))).toList();
        model.addAttribute("lista",lista);
        return "listEventsByCategory";
    }
}
