package mk.finki.ukim.mk.lab.model;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class EventBooking {
    public String eventName;
    public String attendeeName;
    public String attendeeAddress;
    public Long numberOfTickets;


}
