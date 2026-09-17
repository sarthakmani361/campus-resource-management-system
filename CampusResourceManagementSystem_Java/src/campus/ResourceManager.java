package campus;

import java.util.*;

public class ResourceManager {
    private final List<Resource> resources = new ArrayList<>();
    private int nextId = 1;

    public Resource add(String name, ResourceType type) {
        Resource r = new Resource(nextId++, InputValidator.required(name), type, ResourceStatus.AVAILABLE);
        resources.add(r); return r;
    }
    public void addLoaded(Resource r){ resources.add(r); nextId=Math.max(nextId,r.getId()+1); }
    public boolean remove(int id){ return resources.removeIf(r -> r.getId()==id); }
    public Resource find(int id){
        return resources.stream().filter(r->r.getId()==id).findFirst().orElse(null);
    }
    public List<Resource> all(){ return Collections.unmodifiableList(resources); }
    public List<Resource> search(String q){
        String x=q.toLowerCase();
        return resources.stream().filter(r -> r.getName().toLowerCase().contains(x) ||
                r.getType().name().toLowerCase().contains(x) ||
                r.getStatus().name().toLowerCase().contains(x)).toList();
    }
}
