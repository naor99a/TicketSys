import java.util.*;

public class StatsManager implements ITicketsSeverityStatisticsManager {

    //private Collection<ITicketSeverity> tickets = new ArrayList<>(); // todo - remove

    private HashMap<ITicketSeverity.Severity, Set<ITicketSeverity>> severityToTicketsMap = new HashMap();

    public StatsManager() {
        for (ITicketSeverity.Severity severity : ITicketSeverity.Severity.values())
        {
            severityToTicketsMap.put(severity, new HashSet<>());
        }
    }
    @Override
    public void addTicketForAnalyzing(ITicketSeverity ticket) {
        //this.tickets.add(ticket); // todo - remove
        this.severityToTicketsMap.get(ticket.getSeverity()).add(ticket);
    }

    @Override
    public String calcStatistics() {
        return null;
    }

    @Override
    public String calcCVEStatistics() {
        return null;
    }
}
