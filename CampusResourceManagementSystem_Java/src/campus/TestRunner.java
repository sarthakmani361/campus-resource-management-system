package campus;

import java.time.*;

public class TestRunner {
    static int passed=0;
    static void check(boolean condition,String name){if(!condition)throw new AssertionError(name);passed++;}
    public static void main(String[] args){
        ResourceManager rm=new ResourceManager(); BookingManager bm=new BookingManager();
        Resource r=rm.add("ECE Lab",ResourceType.LAB);
        check(rm.find(r.getId())!=null,"resource creation");
        Booking b=bm.create(rm,r.getId(),"Student",LocalDate.of(2026,9,20),
                LocalTime.of(10,0),LocalTime.of(11,0));
        check(bm.all().size()==1,"booking creation");
        boolean conflict=false;
        try{bm.create(rm,r.getId(),"Student2",LocalDate.of(2026,9,20),
                LocalTime.of(10,30),LocalTime.of(11,30));}
        catch(IllegalArgumentException e){conflict=true;}
        check(conflict,"overlap detection");
        check(bm.cancel(b.getId()),"booking cancellation");
        check(rm.remove(r.getId()),"resource removal");
        System.out.println("All tests passed: "+passed);
    }
}
