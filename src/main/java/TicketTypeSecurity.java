public class TicketTypeSecurity extends TicketBaseCVE {
    protected TicketTypeSecurity(String description, Severity severity, String cve) {
        super(description, severity, TicketType.SECURITY, cve);
    }
}
