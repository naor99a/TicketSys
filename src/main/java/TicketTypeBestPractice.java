public class TicketTypeBestPractice extends TicketBaseCVE{
    protected TicketTypeBestPractice(String description, ITicketSeverity.Severity severity, String cve) {
        super(description, severity, TicketBase.TicketType.BEST_PRACTICE, cve);
    }
}
