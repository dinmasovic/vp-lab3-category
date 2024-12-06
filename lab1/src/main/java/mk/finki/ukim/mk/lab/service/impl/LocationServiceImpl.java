package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.LocationRepository;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepository obj;
    public LocationServiceImpl(LocationRepository obj){
        this.obj=obj;
    }

    public List<Location> findAll() {
        return obj.findAll();
    }
    public void save(Location loc){
        obj.save(loc);
    }
    public Location findByID(Long id) {
        if(obj.findById(id).isPresent()){
            return obj.findById(id).get();
        }else
            return null;
    }

}
