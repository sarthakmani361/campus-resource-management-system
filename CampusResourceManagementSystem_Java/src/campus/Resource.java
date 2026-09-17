package campus;

public class Resource {
    private final int id;
    private String name;
    private ResourceType type;
    private ResourceStatus status;

    public Resource(int id, String name, ResourceType type, ResourceStatus status) {
        this.id = id; this.name = name; this.type = type; this.status = status;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public ResourceType getType() { return type; }
    public ResourceStatus getStatus() { return status; }
    public void setName(String name) { this.name = name; }
    public void setType(ResourceType type) { this.type = type; }
    public void setStatus(ResourceStatus status) { this.status = status; }

    public String toCsv() {
        return id + "," + name.replace(",", " ") + "," + type + "," + status;
    }
    public static Resource fromCsv(String line) {
        String[] p = line.split(",", -1);
        return new Resource(Integer.parseInt(p[0]), p[1],
                ResourceType.valueOf(p[2]), ResourceStatus.valueOf(p[3]));
    }
    @Override public String toString() {
        return String.format("#%d | %-22s | %-10s | %s", id, name, type, status);
    }
}
