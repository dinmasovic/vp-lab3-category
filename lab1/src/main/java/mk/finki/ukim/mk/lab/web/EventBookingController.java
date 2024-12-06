package mk.finki.ukim.mk.lab.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/eventBooking")
public class EventBookingController {
    @PostMapping
    public String getEventBooking(Model model, @RequestParam String selectedEvent,@RequestParam String numTickets){
        model.addAttribute("selectedEvent",selectedEvent);
        model.addAttribute("numTickets",numTickets);
        return "bookingConfirmation";
    }

}
