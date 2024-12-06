package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EventService {
        public void setLocation(Long id,Long eventId);
        public List<Event> listAll();
        public List<Event> searchEvents(String text);
        public Event findById(Long id);

        public void removeEvent(Long eventId);
        public void addEvent(Event a);
}
