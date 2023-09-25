public class TicketTypeBestPractice extends TicketBase implements ITicketCVE{
    private String cve;

    protected TicketTypeBestPractice(String description, Severity severity, String cve) {
        super(description, severity, TicketType.BEST_PRACTICE);
        this.cve = cve;
    }

    @Override
    public String getCVE() {
        return this.cve;
    }
}
