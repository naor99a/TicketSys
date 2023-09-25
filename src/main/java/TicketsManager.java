import java.util.*;

public class TicketsManager implements ITicketManager {
    private int lastTicketId = 0;

    // we use HashMap for quick access by key (which is the ticked id)
    private HashMap<Integer, ITicket> tickets = new HashMap<>();

    private TicketStatisticsManager statMgr = new TicketStatisticsManager();

    @Override
    public void addTicket(ITicket ticket) {
        lastTicketId++;
        ticket.setId(lastTicketId);
        tickets.put(lastTicketId, ticket);
        if (ticket instanceof ITicketSeverity)
        {
            statMgr.addTicketForAnalyzing((ITicketSeverity)ticket);
        }
    }

    @Override
    public void removeTicket(ITicket ticket) {
        tickets.remove(ticket.getId());
    }

    @Override
    public ITicket getTicket(int id) {
        return tickets.get(id);
    }

    /**
     * @return a cloned set, containing the tickets objects.
     */
    @Override
    public Collection<ITicket> getTickets() {
        return new HashSet<>(tickets.values());
    }

    public String getStatistics() {
        return statMgr.calcStatistics();
    }
}
