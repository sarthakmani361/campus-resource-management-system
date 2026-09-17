package campus;

import java.util.*;

public class ReportService {
    public String utilization(ResourceManager rm, BookingManager bm) {
        StringBuilder s=new StringBuilder();
        s.append("\n=== RESOURCE UTILIZATION REPORT ===\n");
        for(Resource r:rm.all())
            s.append(String.format("%-22s : %d booking(s)%n",r.getName(),bm.forResource(r.getId()).size()));
        s.append("Total resources: ").append(rm.all().size()).append("\n");
        s.append("Total bookings : ").append(bm.all().size()).append("\n");
        return s.toString();
    }
}
