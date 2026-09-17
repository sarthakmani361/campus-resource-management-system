package campus;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DataStore {
    private final Path dir=Paths.get("data");
    private final Path resources=dir.resolve("resources.csv");
    private final Path bookings=dir.resolve("bookings.csv");

    public void save(ResourceManager rm, BookingManager bm) throws IOException {
        Files.createDirectories(dir);
        Files.write(resources, rm.all().stream().map(Resource::toCsv).toList());
        Files.write(bookings, bm.all().stream().map(Booking::toCsv).toList());
    }
    public void load(ResourceManager rm, BookingManager bm) throws IOException {
        if(Files.exists(resources)) for(String l:Files.readAllLines(resources)) if(!l.isBlank()) rm.addLoaded(Resource.fromCsv(l));
        if(Files.exists(bookings)) for(String l:Files.readAllLines(bookings)) if(!l.isBlank()) bm.addLoaded(Booking.fromCsv(l));
    }
}
