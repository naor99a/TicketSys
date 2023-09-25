public interface ITicketsSeverityStatisticsManager {
    void addTicketForAnalyzing(ITicketSeverity ticket);
    String calcStatistics();
    String calcCVEStatistics();
}
