abstract public class TicketBase implements ITicket, ITicketSeverity {

    static enum TicketType {
        SECURITY, CONFIGURATION, BEST_PRACTICE
    }

    private int id;
    private String description;
    private String resolution;
    private Severity severity;
    private TicketType type;

    protected TicketBase(String description, Severity severity, TicketType type) {
        this.description = description;
        this.severity = severity;
        this.type = type;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getResolution() {
        return this.resolution;
    }

    @Override
    public Severity getSeverity() {
        return this.severity;
    }

    public TicketType getType() {
        return this.type;
    }

    public void setResolutionAndClose(String resolution) {
        this.resolution = resolution;
    }

    // for debugging - can be ignored
    @Override
    public String toString() {
        return "id=" + id +
                "\t, description='" + description + '\'' +
                "\t, resolution='" + resolution + '\'' +
                "\t, severity=" + severity +
                "\t, type=" + type; // todo
    }
}
