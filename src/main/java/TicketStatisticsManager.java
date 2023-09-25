import java.util.*;

public class TicketStatisticsManager implements ITicketsSeverityStatisticsManager {

    private HashMap<ITicketSeverity.Severity, Set<ITicketSeverity>> severityToTicketsMap = new HashMap();
    private HashMap<String, Set<ITicketCVE>> cveToTicketsMap = new HashMap();

    public TicketStatisticsManager() {
        for (ITicketSeverity.Severity severity : ITicketSeverity.Severity.values())
        {
            severityToTicketsMap.put(severity, new HashSet<>());
        }
    }
    @Override
    public void addTicketForAnalyzing(ITicketSeverity ticket) {
        this.severityToTicketsMap.get(ticket.getSeverity()).add(ticket);

        // if the ticket has a CVE, add it to the cve map
        if (ticket instanceof ITicketCVE) {
            String cve = ((ITicketCVE) ticket).getCVE();

            // if the CVE doesn't exist yet, create a new set for it
            if (!cveToTicketsMap.containsKey(cve)) {
                cveToTicketsMap.put(cve, new HashSet<>());
            }

            cveToTicketsMap.get(cve).add((ITicketCVE) ticket);
        }
    }


    @Override
    public String calcStatistics() {
        String str = "";
        for (Map.Entry<ITicketSeverity.Severity, Set<ITicketSeverity>> entry : severityToTicketsMap.entrySet()) {
            str += "\n  " + entry.getKey() + ": " + entry.getValue().size() + " tickets.";
        }

        return str;
    }

    @Override
    public String calcCVEStatistics() {
        String str = "";
        for (Map.Entry<String, Set<ITicketCVE>> entry : cveToTicketsMap.entrySet()) {
            str += "\n  " + entry.getKey() + ": " + entry.getValue().size() + " tickets.";
        }
        return str;
    }
}
