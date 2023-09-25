public class TicketTypeSecurity extends TicketBase implements ITicketCVE{
    private String cve;

    protected TicketTypeSecurity(String description, Severity severity, String cve) {
        super(description, severity, TicketType.SECURITY);
        this.cve = cve;
    }

    @Override
    public String getCVE() {
        return this.cve;
    }
}
