package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.EventRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImpl implements EventService{
    EventRepository obj;
    public EventServiceImpl(EventRepository obj){
        this.obj=obj;
    }

    @Override
    public void setLocation(Long id, Long eventId) {

    }
    public void save(Event event){
        obj.save(event);
    }
    public List<Event> listAll() {
        return obj.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return null;
    }


    public Event findById(Long id) {
        if(obj.findById(id).isPresent()){
            return obj.findById(id).get();
        }else
            return null;
    }
    public Location getLocation(long id){
        return null;
    }
    public void addEvent(Event a){
        obj.save(a);
    }
    public void removeEvent(Long id){
        obj.deleteById(id);
    }

}
