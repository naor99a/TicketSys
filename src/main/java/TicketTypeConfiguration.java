public class TicketTypeConfiguration extends TicketBase {
    protected TicketTypeConfiguration(String description, Severity severity) {
        super(description, severity, TicketType.CONFIGURATION);
    }
}
