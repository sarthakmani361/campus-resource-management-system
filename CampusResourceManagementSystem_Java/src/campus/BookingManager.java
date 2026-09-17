package campus;

import java.time.*;
import java.util.*;

public class BookingManager {
    private final List<Booking> bookings = new ArrayList<>();
    private int nextId=1;

    public Booking create(ResourceManager rm, int resourceId, String user, LocalDate date,
                          LocalTime start, LocalTime end) {
        Resource r=rm.find(resourceId);
        if(r==null) throw new IllegalArgumentException("Resource not found.");
        if(r.getStatus()==ResourceStatus.MAINTENANCE) throw new IllegalArgumentException("Resource is under maintenance.");
        if(!start.isBefore(end)) throw new IllegalArgumentException("Start time must be before end time.");
        for(Booking b: bookings)
            if(b.getResourceId()==resourceId && b.overlaps(date,start,end))
                throw new IllegalArgumentException("Booking conflict: time overlaps booking #"+b.getId());
        return addCorrect(resourceId,InputValidator.required(user),date,start,end);
    }
    private Booking addCorrect(int resourceId,String user,LocalDate date,LocalTime start,LocalTime end){
        Booking b=new Booking(nextId++,resourceId,user,date,start,end); bookings.add(b); return b;
    }
    public void addLoaded(Booking b){bookings.add(b);nextId=Math.max(nextId,b.getId()+1);}
    public boolean cancel(int id){return bookings.removeIf(b->b.getId()==id);}
    public List<Booking> all(){return Collections.unmodifiableList(bookings);}
    public List<Booking> forResource(int id){return bookings.stream().filter(b->b.getResourceId()==id).toList();}
}
