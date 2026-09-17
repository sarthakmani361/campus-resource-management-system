package campus;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private final int id, resourceId;
    private final String user;
    private final LocalDate date;
    private final LocalTime start, end;

    public Booking(int id, int resourceId, String user, LocalDate date, LocalTime start, LocalTime end) {
        this.id=id; this.resourceId=resourceId; this.user=user; this.date=date; this.start=start; this.end=end;
    }
    public int getId(){return id;} public int getResourceId(){return resourceId;}
    public String getUser(){return user;} public LocalDate getDate(){return date;}
    public LocalTime getStart(){return start;} public LocalTime getEnd(){return end;}

    public boolean overlaps(LocalDate d, LocalTime s, LocalTime e) {
        return date.equals(d) && s.isBefore(end) && e.isAfter(start);
    }
    public String toCsv(){ return id+","+resourceId+","+user.replace(","," ")+","+date+","+start+","+end; }
    public static Booking fromCsv(String line){
        String[] p=line.split(",",-1);
        return new Booking(Integer.parseInt(p[0]),Integer.parseInt(p[1]),p[2],
                LocalDate.parse(p[3]),LocalTime.parse(p[4]),LocalTime.parse(p[5]));
    }
    @Override public String toString(){
        return String.format("#%d | Resource %d | %-16s | %s | %s-%s",
                id,resourceId,user,date,start,end);
    }
}
