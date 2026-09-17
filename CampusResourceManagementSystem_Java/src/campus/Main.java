package campus;

import java.time.*;
import java.util.*;

public class Main {
    static final Scanner sc=new Scanner(System.in);
    static final ResourceManager rm=new ResourceManager();
    static final BookingManager bm=new BookingManager();
    static final ReportService reports=new ReportService();
    static final DataStore store=new DataStore();

    public static void main(String[] args) {
        try { store.load(rm,bm); } catch(Exception e){System.out.println("Load warning: "+e.getMessage());}
        System.out.println("=== CAMPUS RESOURCE MANAGEMENT SYSTEM ===");
        while(true){
            System.out.println("\n1.Add resource  2.List resources  3.Search  4.Remove resource");
            System.out.println("5.Create booking  6.List bookings  7.Cancel booking  8.Report  9.Save & Exit");
            System.out.print("Choose: ");
            try{
                int c=Integer.parseInt(sc.nextLine().trim());
                switch(c){
                    case 1 -> addResource(); case 2 -> rm.all().forEach(System.out::println);
                    case 3 -> {System.out.print("Search: "); rm.search(sc.nextLine()).forEach(System.out::println);}
                    case 4 -> {System.out.print("ID: "); System.out.println(rm.remove(Integer.parseInt(sc.nextLine()))?"Removed.":"Not found.");}
                    case 5 -> createBooking(); case 6 -> bm.all().forEach(System.out::println);
                    case 7 -> {System.out.print("Booking ID: "); System.out.println(bm.cancel(Integer.parseInt(sc.nextLine()))?"Cancelled.":"Not found.");}
                    case 8 -> System.out.print(reports.utilization(rm,bm));
                    case 9 -> {store.save(rm,bm); System.out.println("Saved. Goodbye."); return;}
                    default -> System.out.println("Choose 1-9.");
                }
            }catch(Exception e){System.out.println("Error: "+e.getMessage());}
        }
    }
    static void addResource(){
        System.out.print("Name: "); String n=sc.nextLine();
        System.out.print("Type (LAB/CLASSROOM/EQUIPMENT): "); ResourceType t=ResourceType.valueOf(sc.nextLine().trim().toUpperCase());
        System.out.println("Added: "+rm.add(n,t));
    }
    static void createBooking(){
        System.out.print("Resource ID: "); int id=Integer.parseInt(sc.nextLine());
        System.out.print("User: "); String u=sc.nextLine();
        System.out.print("Date (YYYY-MM-DD): "); LocalDate d=InputValidator.date(sc.nextLine());
        System.out.print("Start (HH:MM): "); LocalTime s=InputValidator.time(sc.nextLine());
        System.out.print("End (HH:MM): "); LocalTime e=InputValidator.time(sc.nextLine());
        System.out.println("Created: "+bm.create(rm,id,u,d,s,e));
    }
}
