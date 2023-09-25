abstract public class TicketBaseCVE extends TicketBase implements ITicketCVE {
    private String cve;
    protected TicketBaseCVE(String description, Severity severity, TicketType type, String cve) {
        super(description, severity, type);
        this.cve = cve;
    }

    @Override
    public String getCVE() {
        return this.cve;
    }

    @Override
    public String toString() {
        return super.toString() + "\t, CVE_num: " + cve;
    }
}
