package mk.finki.ukim.mk.lab.model;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Data
@Entity
@Table(name = "Event")
public class Event {
    public String name;
    public String description;
    public double popularityScore;
    @jakarta.persistence.Id
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Location location;
    @ManyToOne
    private Category category;
    public Event(String name,String description,double popularityScore){
        this.description=description;
        this.name=name;
        this.popularityScore=popularityScore;
    }
    public Event(){}
    public void setLocation(Location o){
        location=o;
    }
    public void setCategory(Category o){
        category=o;
    }
    public Location getLocation(){
        return location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Long getLocationId(){return location.getId();}
}
