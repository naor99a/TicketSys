public interface ITicketSeverity {
    enum Severity {
        HIGH, MEDIUM, LOW
    }

    Severity getSeverity();
}
